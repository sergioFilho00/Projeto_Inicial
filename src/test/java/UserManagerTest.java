import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void beforeEach(){
        userManager = new UserManager();
        userManager.deleteUser("test_user");
    }

    @Test
    public void testAddUser(){
        //cria um novo usuario
        User user = new User("sergio_filho", "sergio@filho.com", "sergiopass");

        //adicina o usuario ao UserManager
        userManager.addUser(user);

        //verifica se o usuario foi adicionado corretamente
        Assert.assertEquals(user, userManager.getUser("sergio_filho"));

    }

    @Test
    public void testGetUser(){

        //cria e adiciona um usuario
        User user = new User("fernanda_lima", "fernanda@lima.com", "fernandapass");
        userManager.addUser(user);

        // verifica se o usuário pode ser obtido corretamente
        User retrievedUser = userManager.getUser("fernanda_lima");
        Assert.assertNotNull(retrievedUser);
        Assert.assertEquals("fernanda_lima", retrievedUser.getUsername());

    }

    @Test
    public void testUpdateUser(){
        //cria e adiciona um usuario
        User user = new User ("sergio_filho", "sergio@filho.com", "sergiopass");
        userManager.addUser(user);

        //atualiza o usuario
        userManager.updateUser("sergio_filho", "sergio@novo.com", "sergionew");

        //verifica se as informações do usuario foram atualizadas corretamente
        User updateUser = userManager.getUser("sergio_filho");
        Assert.assertEquals("sergio@novo.com", updateUser.getEmail());
        Assert.assertEquals("sergionew", updateUser.getPassword());

    }

    @Test
    public void testDeleteUser(){
        //cria e adiciona um usuario
        User user = new User("fernanda_lima", "fernanda@lima.com", "fernandapass");
        userManager.addUser(user);

        //deleta o usuario
        userManager.deleteUser("fernanda_lima");

        //verifica se  usuario foi deletado
        Assert.assertNull(userManager.getUser("fernanda_lima"));
    }

    @Test
    public void testAddUserComNomeVazio(){
        //tenta adicionar um usuario com nome vazio
        User user = new User("", "vazio@novo.com", "pass");
        userManager.addUser(user);

        //verifica se o usuario com nome vazio nao foi adicionado corretamente
        Assert.assertNull(userManager.getUser(""));
    }
}
