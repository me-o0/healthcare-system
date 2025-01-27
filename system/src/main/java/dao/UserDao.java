package dao;

import model.User;

public interface UserDao {
    String getUserPassword(String username);
    boolean checkIfUserExists(String username);
    boolean isAccountLocked(String username);
    boolean incrementFailedAttempts(String username);
    boolean createUser(String username, String password, String email);
    String generateResetToken(String email);
    boolean checkIfEmailExists(String email);
    boolean setUserRole(int userId, String role);
    boolean saveLoginHistory(int userId, String ipAddress, String status);
    boolean verifyPassword(String plainPassword, String hashedPassword);
    boolean resetFailedAttempts(String username);
    User getUserByUsername(String username);
}
