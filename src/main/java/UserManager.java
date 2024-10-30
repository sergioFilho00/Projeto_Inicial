import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> users;
    private static final String data_file = "C:\\Users\\a933760\\OneDrive - ATOS\\Projeto Inicial\\ProjetoInicial\\src\\main\\users.json";
    private Gson gson;

    public UserManager() {
        gson = new Gson();
        users = loadUsers();
        this.users = new ArrayList<>();
    }

    private List<User> loadUsers() {
        try(FileReader reader = new FileReader(data_file)){
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
            return gson.fromJson(reader, userListType);
        }catch (IOException e){
            System.out.println("Arquivo não encontrado, criando uma nova lista de usuários");
            return new ArrayList<>();
        }
    }

    private void saveUsers(){
        try(FileWriter writer = new FileWriter(data_file)){
            gson.toJson(users, writer);
        }catch (IOException e){
            System.out.println("Erro ao salvar os dados dos usuários");
        }
    }

    public void addUser(User user){
        if (user.getUsername() == null || user.getUsername().isEmpty()){
            System.out.println("Nome de usuário inválido.O usuário não foi adicionado.");
        return;
        }

        users.add(user);
        saveUsers();
    }

    public User getUser (String username){

        for (User user : users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public void updateUser (String username, String newEmail, String newPassword){

        User user = getUser(username);
        if (user != null){
            user.setEmail(newEmail);
            user.setPassword(newPassword);
            saveUsers();
        }else {
            System.out.println("Usuario não encontrado");
        }
    }

    public void deleteUser (String username){
        if (users.removeIf(user -> user.getUsername().equals(username))){
         saveUsers();
        }else {
            System.out.println("Usuario não encontrado");
        }

    }
}
