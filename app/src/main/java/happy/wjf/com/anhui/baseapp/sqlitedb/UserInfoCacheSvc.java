package happy.wjf.com.anhui.baseapp.sqlitedb;

import android.util.Log;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;

/**
 * 缓存用户信息（主要用于聊天显示昵称和头像）
 */
public class UserInfoCacheSvc {
	public static List<UserApiModel> getAllList(){
		Dao<UserApiModel, Integer> daoScene = SqliteHelper.getInstance().getUserDao();
		try {
			List<UserApiModel> list = daoScene.queryBuilder().query();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static UserApiModel getByChatUserName(String chatUserName){
		Dao<UserApiModel, Integer> dao = SqliteHelper.getInstance().getUserDao();
		try {
			UserApiModel model = dao.queryBuilder().where().eq("EaseMobUserName", chatUserName).queryForFirst();
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static UserApiModel getById(long id){
		Dao<UserApiModel, Integer> dao = SqliteHelper.getInstance().getUserDao();
		try {
			UserApiModel model = dao.queryBuilder().where().eq("Id", id).queryForFirst();
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static boolean createOrUpdate(String chatUserName, String userNickName, String avatarUrl){
		try {
			Dao<UserApiModel, Integer> dao = SqliteHelper.getInstance().getUserDao();

			UserApiModel user = getByChatUserName(chatUserName);

//			if (!StringUtils.isNullOrEmpty(avatarUrl)){
//				avatarUrl = ImgSize.GetThumbnail(avatarUrl, ImgSize.ThumbMod_Crop, 100, 100);
//			}

			int changedLines = 0;
			if (user == null){
				user = new UserApiModel();
				user.setUsername(userNickName);
				user.setHeadImg(avatarUrl);
				user.setEaseMobUserName(chatUserName);

				changedLines = dao.create(user);
			}else {
				user.setUsername(userNickName);
				user.setHeadImg(avatarUrl);
				user.setEaseMobUserName(chatUserName);

				changedLines = dao.update(user);
			}

			if(changedLines > 0){
				Log.i("UserInfoCacheSvc", "操作成功~");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Log.e("UserInfoCacheSvc", "操作异常~");
		}
		
		return false;
	}

	public static boolean createOrUpdate(UserApiModel model){

		if(model == null) return false;

		try {
			Dao<UserApiModel, Integer> dao = SqliteHelper.getInstance().getUserDao();

			UserApiModel user = getById(model.Id);

			if (!StringUtils.isNullOrEmpty(model.getHeadImg())){
                // 拼接头像的完整路径，或者直接用服务端返回的绝对路径
				String fullPath = "http://image.baidu.com/" + model.getHeadImg();
				model.setHeadImg(fullPath);
			}
			int changedLines = 0;
			if (user == null){
				changedLines = dao.create(model);
			}else {
				model.setRecordId(user.getRecordId());
				changedLines = dao.update(model);
			}

			if(changedLines > 0){
				Log.i("UserInfoCacheSvc", "操作成功~");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Log.e("UserInfoCacheSvc", "操作异常~");
		}

		return false;
	}

}
