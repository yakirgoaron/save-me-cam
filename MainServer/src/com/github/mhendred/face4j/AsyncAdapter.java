/**
 * Auto-generated class
 */
package com.github.mhendred.face4j;

import java.util.List;

import com.github.mhendred.face4j.exception.FaceClientException;
import com.github.mhendred.face4j.exception.FaceServerException;
import com.github.mhendred.face4j.model.Namespace;
import com.github.mhendred.face4j.model.Photo;
import com.github.mhendred.face4j.model.RemovedTag;
import com.github.mhendred.face4j.model.SavedTag;
import com.github.mhendred.face4j.model.UserStatus;
import com.github.mhendred.face4j.response.GroupResponse;
import com.github.mhendred.face4j.response.LimitsResponse;
import com.github.mhendred.face4j.response.TrainResponse;
import com.github.mhendred.face4j.response.UsersResponse;

public class AsyncAdapter implements RequestListener
{

	@Override
	public void onAddTag ()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onDetect (Photo photo)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onDetect (List<Photo> photos)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onFaceClientException (FaceClientException fce, FaceApi faceApi)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onFaceServerException (FaceServerException fse, FaceApi faceApi)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onFacebookGet (List<Photo> photos)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetLimits (LimitsResponse response)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetNamespace (Namespace namespace)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetNamespaces (List<Namespace> namespaces)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onGetTags (List<Photo> photos)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onGroup (GroupResponse response)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onRecognize (Photo photo)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onRecognize (List<Photo> photos)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onRemoveTags (List<RemovedTag> removedTags)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onSaveTags (List<SavedTag> savedTags)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatus (List<UserStatus> userStatus)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTrain (TrainResponse response)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onUsers (UsersResponse response)
	{
		// TODO Auto-generated method stub

	}

}
