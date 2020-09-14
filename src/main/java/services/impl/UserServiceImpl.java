package services.impl;

import entities.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import services.UserService;

/** Created by kopuz on 7/10/2018. */
public class UserServiceImpl implements UserService {

  /**
   * Method which create User entities
   *
   * @return
   */
  @Override
  public List<User> createUserList() {

    List<User> userList = new ArrayList<>();

    LocalDate userBirthday = LocalDate.of(1984, 5, 7);
    User user =
        new User(
            "alper",
            "kopuz",
            "nilufer",
            "mustafa",
            java.sql.Date.valueOf(userBirthday),
            "alperkopuz@gmail.com",
            "02163324559",
            "05333849638",
            "ortabayir mahallesi erler sokak no:3 daire:2 kagithane istanbul");
    userList.add(user);

    userBirthday = LocalDate.of(1980, 5, 7);
    user =
        new User(
            "connor",
            "mcregor",
            "rebecca",
            "george",
            java.sql.Date.valueOf(userBirthday),
            "gregorconnor@gmail.com",
            "004253698632",
            "00425689632",
            "ireland");
    userList.add(user);

    return userList;
  }
}
