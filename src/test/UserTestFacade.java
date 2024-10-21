import vendaingressos.Usuario;
import vendaingressos.UsuarioManager;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class UserTestFacade {
    // Classes para trabalhar com os testes

    public UserTestFacade() {}

    public boolean create(String login, String password, String name, String cpf, String email, Boolean isAdmin) throws IOException {
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
        UsuarioManager usuarioManager = new UsuarioManager();
        return usuarioManager.adicionarUsuarioNoArquivo(login, password, name, cpf, email, isAdmin, id);
    }

    public String getLoginByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.getLogin();
            }
        }
        return null;
    }

    public void setNameByUserEmail(String name, String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.setNome(name);
            }
        }
    }

    public void setPasswordByUserEmail(String password, String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.setNome(password);
            }
        }
    }

    public void setEmailByUserEmail(String newEmail, String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.setNome(email);
            }
        }
    }

    public String getNameByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.getNome();
            }
        }
        return null;
    }

    public String getEmailByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.getEmail();
            }
        }
        return null;
    }


    public String getPasswordByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.getSenha();
            }
        }
        return null;
    }

    public String getCpfByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.getCpf();
            }
        }
        return null;
    }

    public boolean getIsAdminByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.isAdmin();
            }
        }
        return false;
    }

    public boolean thereIsUserWithEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;

    }

    public int getSizeUsers() throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        return usuarios.size();
    }

    public void deleteAllUsers() throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        usuarioManager.limparArquivoJson();
    }

    public void deleteByUserEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        usuarioManager.deletarUsuarioPorEmail(email, usuarios);
    }

    public boolean login(String login, String password) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getUserIdByEmail(String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario.getId();
            }
        }
        return null;
    }
}
