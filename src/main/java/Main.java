
public class Main {

    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        //add user
        userManager.addUser(new User("sergio_filho", "sergio@filho.com", "sergiopass"));
        userManager.addUser(new User("fernanda_lima", "fernanda@lima.com", "fernandapass"));

        //obtendo user
        User user = userManager.getUser("sergio_filho");
        System.out.println("Usuário encontrado: " + user);

        //atualizando um usuario
        userManager.updateUser("fernanda_lima", "fernanda_lima@new.com", "limapass");

        //deletando usuário
        userManager.deleteUser("fernanda_lima");

        //listando todos os usuários restantes
        System.out.println("Usuários restantes: " + userManager.getUser("sergio_filho"));
    }
}
