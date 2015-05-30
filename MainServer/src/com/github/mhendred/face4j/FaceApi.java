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

/**
 * Holds the path to the resources on api.skybiometry.com/fc
 * 
 * @author Marlon Hendred
 *
 */
public enum FaceApi 
{
	RECOGNIZE("/fc/faces/recognize.json", true),
	DETECT("/fc/faces/detect.json", false),
	GROUP("/fc/faces/group.json", true),
	TRAIN("/fc/faces/train.json", true),
	STATUS("/fc/faces/status.json",true),
	REMOVE_TAGS("/fc/tags/remove.json", true),
	SAVE_TAGS("/fc/tags/save.json", true),
	GET_TAGS("/fc/tags/get.json", true),
	ADD_TAG("/fc/tags/add.json", true),
	LIMITS("/fc/account/limits.json", false),
	NAMESPACES("/fc/account/namespaces.json", false),
	USERS("/fc/account/users.json", false),
	FACEBOOK("/fc/facebook/get.json", true);
	
	private final String path;
	
	private final boolean takesAuth;
	
	private FaceApi (String path, boolean takesAuth) 
	{
		this.path = path;
		this.takesAuth = takesAuth;
	}
	
	public String getPath ()
	{
		return path;
	}
	
	public boolean takesAuth ()
	{
		return takesAuth;
	}
}