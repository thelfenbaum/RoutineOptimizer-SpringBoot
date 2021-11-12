package accessingdatajpa;

public class UserController {
    UserInteractor userInter;

    public UserController(UserInteractor userInter){
        this.userInter = userInter;
    }
}
