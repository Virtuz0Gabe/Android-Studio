package devandroid.gabriel.viaCep.Models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ViaCepService {
    public static final String BASE_URL = "https://viacep.com.br/ws/";
    // https://viacep.com.br/ws/01001000/json/
    @GET("{cep}/json/")
    Call<Endereco> endereco(@Path("cep") String cep);
}
