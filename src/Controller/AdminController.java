package Controller;

import Models.Admin;
import Repository.AdminsRepository;

public class AdminController {
    private static AdminController instance;
    private final AdminsRepository adminsRepository;

    private AdminController(AdminsRepository adminsRepository) {
        this.adminsRepository = adminsRepository;
    }

    public static AdminController getInstance(AdminsRepository adminsRepository) {
        if (instance == null) {
            instance = new AdminController(adminsRepository);
        }
        return instance;
    }

    public boolean login(String login, String password) {
        Admin admin = adminsRepository.findOne(login);
        if (admin == null || !admin.getPassword().equals(password)) {
            return false;
        }
        SessionUserController.user = admin;
        SessionUserController.isAdmin = true;
        return true;
    }

    public boolean create(Admin admin) {
        return adminsRepository.create(admin);
    }

}
