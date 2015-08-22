/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-08-22 at 11:13:19 UTC 
 * Modify at your own risk.
 */

package com.cam.UI.server;

/**
 * Service definition for Users (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link UsersRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Users extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the users library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://uplifted-plate-89814.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "users/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Users(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Users(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "deleteuser".
   *
   * This request holds the parameters needed by the users server.  After setting any optional
   * parameters, call the {@link Deleteuser#execute()} method to invoke the remote operation.
   *
   * @param cameraName
   * @param userName
   * @return the request
   */
  public Deleteuser deleteuser(java.lang.String cameraName, java.lang.String userName) throws java.io.IOException {
    Deleteuser result = new Deleteuser(cameraName, userName);
    initialize(result);
    return result;
  }

  public class Deleteuser extends UsersRequest<Void> {

    private static final String REST_PATH = "DeleteUser/{CameraName}/{UserName}";

    /**
     * Create a request for the method "deleteuser".
     *
     * This request holds the parameters needed by the the users server.  After setting any optional
     * parameters, call the {@link Deleteuser#execute()} method to invoke the remote operation. <p>
     * {@link
     * Deleteuser#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param cameraName
     * @param userName
     * @since 1.13
     */
    protected Deleteuser(java.lang.String cameraName, java.lang.String userName) {
      super(Users.this, "POST", REST_PATH, null, Void.class);
      this.cameraName = com.google.api.client.util.Preconditions.checkNotNull(cameraName, "Required parameter cameraName must be specified.");
      this.userName = com.google.api.client.util.Preconditions.checkNotNull(userName, "Required parameter userName must be specified.");
    }

    @Override
    public Deleteuser setAlt(java.lang.String alt) {
      return (Deleteuser) super.setAlt(alt);
    }

    @Override
    public Deleteuser setFields(java.lang.String fields) {
      return (Deleteuser) super.setFields(fields);
    }

    @Override
    public Deleteuser setKey(java.lang.String key) {
      return (Deleteuser) super.setKey(key);
    }

    @Override
    public Deleteuser setOauthToken(java.lang.String oauthToken) {
      return (Deleteuser) super.setOauthToken(oauthToken);
    }

    @Override
    public Deleteuser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Deleteuser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Deleteuser setQuotaUser(java.lang.String quotaUser) {
      return (Deleteuser) super.setQuotaUser(quotaUser);
    }

    @Override
    public Deleteuser setUserIp(java.lang.String userIp) {
      return (Deleteuser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key("CameraName")
    private java.lang.String cameraName;

    /**

     */
    public java.lang.String getCameraName() {
      return cameraName;
    }

    public Deleteuser setCameraName(java.lang.String cameraName) {
      this.cameraName = cameraName;
      return this;
    }

    @com.google.api.client.util.Key("UserName")
    private java.lang.String userName;

    /**

     */
    public java.lang.String getUserName() {
      return userName;
    }

    public Deleteuser setUserName(java.lang.String userName) {
      this.userName = userName;
      return this;
    }

    @Override
    public Deleteuser set(String parameterName, Object value) {
      return (Deleteuser) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getusers".
   *
   * This request holds the parameters needed by the users server.  After setting any optional
   * parameters, call the {@link Getusers#execute()} method to invoke the remote operation.
   *
   * @param userName
   * @return the request
   */
  public Getusers getusers(java.lang.String userName) throws java.io.IOException {
    Getusers result = new Getusers(userName);
    initialize(result);
    return result;
  }

  public class Getusers extends UsersRequest<com.cam.UI.server.UserCollection> {

    private static final String REST_PATH = "GetUsers/{userName}";

    /**
     * Create a request for the method "getusers".
     *
     * This request holds the parameters needed by the the users server.  After setting any optional
     * parameters, call the {@link Getusers#execute()} method to invoke the remote operation. <p>
     * {@link
     * Getusers#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param userName
     * @since 1.13
     */
    protected Getusers(java.lang.String userName) {
      super(Users.this, "POST", REST_PATH, null, com.cam.UI.server.UserCollection.class);
      this.userName = com.google.api.client.util.Preconditions.checkNotNull(userName, "Required parameter userName must be specified.");
    }

    @Override
    public Getusers setAlt(java.lang.String alt) {
      return (Getusers) super.setAlt(alt);
    }

    @Override
    public Getusers setFields(java.lang.String fields) {
      return (Getusers) super.setFields(fields);
    }

    @Override
    public Getusers setKey(java.lang.String key) {
      return (Getusers) super.setKey(key);
    }

    @Override
    public Getusers setOauthToken(java.lang.String oauthToken) {
      return (Getusers) super.setOauthToken(oauthToken);
    }

    @Override
    public Getusers setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Getusers) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Getusers setQuotaUser(java.lang.String quotaUser) {
      return (Getusers) super.setQuotaUser(quotaUser);
    }

    @Override
    public Getusers setUserIp(java.lang.String userIp) {
      return (Getusers) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String userName;

    /**

     */
    public java.lang.String getUserName() {
      return userName;
    }

    public Getusers setUserName(java.lang.String userName) {
      this.userName = userName;
      return this;
    }

    @Override
    public Getusers set(String parameterName, Object value) {
      return (Getusers) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Users}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Users}. */
    @Override
    public Users build() {
      return new Users(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link UsersRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setUsersRequestInitializer(
        UsersRequestInitializer usersRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(usersRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
