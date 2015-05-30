/*
 * Copyright (c) 2010 Marlon Hendred
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.mhendred.face4j;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.net.HttpURLConnection;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.github.mhendred.face4j.exception.FaceClientException;
import com.github.mhendred.face4j.exception.FaceServerException;


/**
 * Default implementation of {@link Responder} interface. It seems as though
 * SkyBiometry always returns an HTTP status code of 200 even for 404 not founds.
 * This is why there is no need to check the status line.
 * 
 * @author Marlon Hendred
 *
 */
class ResponderImpl implements Responder
{
	
	/**
	 * "failure" string constant
	 */
	private static final String FAILURE = "failure";
	
	/**
	 * {@link HttpClient} for executing requests
	 */
	private final HttpURLConnection httpClient;
	
	/**
	 * {@link HttpPost} method for {@code POST}s
	 */
	private final HttpPost postMethod;
	
	/**
	 * {@link HttpGet} method for {@code GET}s
	 */
	private final HttpGet getMethod;
	
	public ResponderImpl()
	{
		this.httpClient = null;	
		this.postMethod = new HttpPost();
		this.getMethod  = new HttpGet();
	}

	/** 
	 * @see {@link Responder#doPost(URI, List)}
	 */
	public String doPost(final URI uri, final List<NameValuePair> params) throws FaceClientException, FaceServerException
	{		
		try
		{
			URL url = uri.toURL();

		   		    
		    StringBuilder strparams = new StringBuilder();
		    for (Iterator iterator = params.iterator(); iterator.hasNext();) 
		    {
				NameValuePair nameValuePair = (NameValuePair) iterator.next();
				strparams.append(nameValuePair.getName());
				strparams.append("=");
				strparams.append(nameValuePair.getValue());
				strparams.append("&");
			}
		    
		    strparams.deleteCharAt(strparams.length()-1);
		    byte[] postData  = strparams.toString().getBytes();
		    String urlpath = url.toString();
		    url = new URL(urlpath + "?" + strparams.toString());
		    
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		  
		    /*connection.setRequestProperty("X-Custom-Header", "xxx");
		    connection.setRequestProperty("Content-Type", "application/json");*/

		    // POST the http body data
//		    connection.setDoOutput(true);
		    //connection.setRequestMethod("GET");
 
		    /*connection.setRequestProperty( "Content-Length",Integer.toString( postData.length ));
		    DataOutputStream  writer = new DataOutputStream(connection.getOutputStream());
		    writer.write(postData);
		    writer.close();*/

		    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
		        // OK
		        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer res = new StringBuffer();
		        String line;
		        while ((line = reader.readLine()) != null) {
		            res.append(line);
		        }
		        reader.close();

		        return res.toString();

		    } else {
		    	 int resp =  connection.getResponseCode();
		    	 
		    	 BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		    	 StringBuffer res = new StringBuffer();
			        String line;
			        while ((line = reader.readLine()) != null) {
			            res.append(line);
			        }
			        reader.close();
			     return line;
		    }

		}
		
		catch (IOException ioe)
		{
			throw new FaceClientException(ioe);
		}
	}
	
	/**
	 * @see {@link Responder#doPost(File, URI, List)}
	 */
	public String doPost(final File file, final URI uri, final List<NameValuePair> params) throws  FaceClientException, FaceServerException
	{		
		/*try
		{
			final MultipartEntity entity = new MultipartEntity();	
			
		
			entity.addPart("image", new FileBody(file));

			try 
			{
				for (NameValuePair nvp : params)
				{
					entity.addPart(nvp.getName(), new StringBody(nvp.getValue()));
				}
			}
			
			catch (UnsupportedEncodingException uee)
			{
				throw new FaceClientException(uee);
			}
		
			postMethod.setURI(uri);
			postMethod.setEntity(entity);
			
			final long start = System.currentTimeMillis();
			final HttpResponse response = httpClient.execute(postMethod);

			*/
			return "";///checkResponse(response);
		/*}
		
		catch (IOException ioe)
		{
			throw new FaceClientException(ioe);
		}*/
	}
	
	/**
	 * @see {@code Responder#doGet(URI)}
	 */
	public String doGet (final URI uri) throws  FaceClientException, FaceServerException
	{
		getMethod.setURI(uri);
		
		/*try 
		{*/
			//final HttpResponse response = httpClient.execute(getMethod);
			return "";//checkResponse(response);
		//}
		
		/*catch (IOException ioe)
		{
			throw new FaceClientException(ioe);
		}*/
	}
	
	private String checkResponse(HttpResponse httpResponse) throws FaceServerException, FaceClientException
	{
		try 
		{
			final String json = EntityUtils.toString(httpResponse.getEntity());
		
			if (json.contains(FAILURE))
			{
				final JSONObject obj = new JSONObject(json);
				final String message = obj.getString("error_message");
				final int errorCode  = obj.getInt("error_code");
				
				final FaceServerException fse = new FaceServerException(message, errorCode);

				
				throw fse;	
			}
			
			else 
			{

				
				return json;
			}
		
		}
		
		catch (JSONException jse)
		{
			throw new FaceClientException(jse);
		}
		
		catch (IOException ioe)
		{
			throw new FaceClientException(ioe);
		}
	}
}