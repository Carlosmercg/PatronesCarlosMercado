package co.edu.java.encriptacion;

public class ProcesoEncriptarCesar implements InterfaceEncriptar {

    @Override
    public String encryptar(String message,
                            String password) throws Exception {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("El password no puede ser nulo o vacío.");
        }

        // Usamos la suma de los caracteres del password como "clave"
        int shift = 0;
        for (char c : password.toCharArray()) {
            shift += c;
        }
        shift = shift % 26;

        StringBuilder encrypted = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char enc = (char) ((ch - base + shift) % 26 + base);
                encrypted.append(enc);
            } else {
                encrypted.append(ch); // no alteramos símbolos, espacios, números
            }
        }
        return encrypted.toString();
    }
}
