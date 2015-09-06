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
 * on 2015-09-06 at 19:21:43 UTC 
 * Modify at your own risk.
 */

package com.appspot.uplifted_plate_89814.query.model;

/**
 * Model definition for EventsForUser.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the query. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class EventsForUser extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key("URL")
  private java.lang.String uRL;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double confidance;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime date;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String eventtype;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String message;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getURL() {
    return uRL;
  }

  /**
   * @param uRL uRL or {@code null} for none
   */
  public EventsForUser setURL(java.lang.String uRL) {
    this.uRL = uRL;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getConfidance() {
    return confidance;
  }

  /**
   * @param confidance confidance or {@code null} for none
   */
  public EventsForUser setConfidance(java.lang.Double confidance) {
    this.confidance = confidance;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getDate() {
    return date;
  }

  /**
   * @param date date or {@code null} for none
   */
  public EventsForUser setDate(com.google.api.client.util.DateTime date) {
    this.date = date;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getEventtype() {
    return eventtype;
  }

  /**
   * @param eventtype eventtype or {@code null} for none
   */
  public EventsForUser setEventtype(java.lang.String eventtype) {
    this.eventtype = eventtype;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessage() {
    return message;
  }

  /**
   * @param message message or {@code null} for none
   */
  public EventsForUser setMessage(java.lang.String message) {
    this.message = message;
    return this;
  }

  @Override
  public EventsForUser set(String fieldName, Object value) {
    return (EventsForUser) super.set(fieldName, value);
  }

  @Override
  public EventsForUser clone() {
    return (EventsForUser) super.clone();
  }

}
