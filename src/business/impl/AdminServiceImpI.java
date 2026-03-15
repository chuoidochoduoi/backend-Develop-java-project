package business.impl;

import business.IAdminService;
import dao.impl.AdminDao;

public class AdminServiceImpI implements IAdminService {

     AdminDao adminDao = new AdminDao();

    public boolean login(String username,String password){
        return adminDao.login(username,password);
    }


}
