package interfaces;

import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@FunctionalInterface
public interface HandlerExceptionConsumer<T, U> {

	void accept(T t, U u) throws Exception;

	static <T, U> BiConsumer<T, U> handlingBiConsumerWrapper(HandlerExceptionConsumer<T, U> consumer) {
		
		return (i, j) -> {
			try {

				consumer.accept(i,j);

			}catch ( Exception e) {

				throw new RuntimeException(e);

			}
		};
	}
	
}
