package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import request.receive.GenericResponse;
import request.receive.ResponseType;
import request.receive.*;

public abstract class RequestDeserializer {

	public static Gson getDeserializer() {
		RuntimeTypeAdapterFactory<GenericResponse> typeAdapterFactory = RuntimeTypeAdapterFactory
				.of(GenericResponse.class, "type")
				.registerSubtype(AuthentificationResponse.class, ResponseType.AUTHENTIFICATION.toString())
				.registerSubtype(ErrorResponse.class, ResponseType.ERROR.toString())
				.registerSubtype(SuccessResponse.class, ResponseType.SUCCESS.toString())
				.registerSubtype(SearchResponse.class, ResponseType.SEARCH.toString())
				.registerSubtype(ImageResponse.class, ResponseType.IMAGE.toString());

		return new GsonBuilder().registerTypeAdapterFactory(typeAdapterFactory).create();
	}
}