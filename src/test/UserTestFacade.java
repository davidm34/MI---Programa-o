import vendaingressos.Usuario;
import vendaingressos.UsuarioManager;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class UserTestFacade {
    // Classes para trabalhar com os testes

    public UserTestFacade() {}

    public boolean create(String login, String password, String name, String cpf, String email, Boolean isAdmin) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                throw new SecurityException("Login, email e/ou cpf já está em uso.");
            }
        }
        UUID uuid = UUID.randomUUID();
        String id = String.valueOf(uuid);
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

    public void setNameByUserEmail(String newName, String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.setNome(newName);
                usuarioManager.salvarUsuarios(usuarios); // Salva as alterações no arquivo
                return;
            }
        }
    }

    public void setPasswordByUserEmail(String newPassword, String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.setSenha(newPassword);
                usuarioManager.salvarUsuarios(usuarios);
                return;
            }
        }
    }

    public void setEmailByUserEmail(String newEmail, String email) throws IOException {
        UsuarioManager usuarioManager = new UsuarioManager();
        List<Usuario> usuarios = usuarioManager.lerConteudoArquivo();
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                usuario.setEmail(newEmail);
                usuarioManager.salvarUsuarios(usuarios);
                return;
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
        usuarioManager.salvarUsuarios(usuarios);
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
