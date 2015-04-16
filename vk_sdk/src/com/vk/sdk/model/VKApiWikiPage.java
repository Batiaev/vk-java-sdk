//
//  Copyright (c) 2014 VK.com
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy of
//  this software and associated documentation files (the "Software"), to deal in
//  the Software without restriction, including without limitation the rights to
//  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
//  the Software, and to permit persons to whom the Software is furnished to do so,
//  subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
//  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
//  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
//  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
//  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//

/**
 * WikiPage.java
 * vk-android-sdk
 *
 * Created by Babichev Vitaly on 19.01.14.
 * Copyright (c) 2014 VK. All rights reserved.
 */
package com.vk.sdk.api.model;

import org.json.JSONException;
import org.json.JSONObject;
import static com.vk.sdk.api.model.VKAttachments.*;

/**
 * Describes a Wiki page.
 */
@SuppressWarnings("unused")
public class VKApiWikiPage extends VKAttachments.VKApiAttachment {

    /**
     * Wiki page ID;
     */
    public int id;

    /**
     * ID of the group the wiki page belongs to;
     */
    public int group_id;

    /**
     * ID of the page creator.
     */
    public int creator_id;

    /**
     * Wiki page name.
     */
    public String title;

    /**
     * Text of the wiki page.
     */
    public String source;

    /**
     * Whether a user can edit page text (false — cannot, true — can).
     */
    public boolean current_user_can_edit;

    /**
     * Whether a user can edit page access permissions (false — cannot, true — can).
     */
    public boolean current_user_can_edit_access;

    /**
     * Who can view the wiki page(0 — only community managers, 1 — only community members, 2 — all users).
     */
    public int who_can_view;

    /**
     * Who can edit the wiki page (0 — only community managers, 1 — only community members, 2 — all users).
     */
    public int who_can_edit;

    /**
     * ID of the last user who edited the page.
     */
    public int editor_id;

    /**
     * Date of the last change.
     */
    public long edited;

    /**
     * Page creation date.
     */
    public long created;

    /**
     * Title of the parent page for navigation, if any.
     */
    public String parent;

    /**
     * Title of the second parent page for navigation, if any.
     */
    public String parent2;

	public VKApiWikiPage(JSONObject from) throws JSONException
	{
		parse(from);
	}
    /**
     * Fills a WikiPage instance from JSONObject.
     */
    public VKApiWikiPage parse(JSONObject source) {
        id = source.optInt("id");
        group_id = source.optInt("group_id");
        creator_id = source.optInt("creator_id");
        title = source.optString("title");
        this.source = source.optString("source");
        current_user_can_edit = ParseUtils.parseBoolean(source, "current_user_can_edit");
        current_user_can_edit_access = ParseUtils.parseBoolean(source, "current_user_can_edit_access");
        who_can_view = source.optInt("who_can_view");
        who_can_edit = source.optInt("who_can_edit");
        editor_id = source.optInt("editor_id");
        edited = source.optLong("edited");
        created = source.optLong("created");
        parent = source.optString("parent");
        parent2 = source.optString("parent2");
        return this;
    }

    /**
     * Creates empty WikiPage instance.
     */
    public VKApiWikiPage() {

    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuilder(TYPE_WIKI_PAGE).append(group_id).append('_').append(id);
    }

    @Override
    public String getType() {
        return TYPE_WIKI_PAGE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public int getId() {
        return id;
    }
}
