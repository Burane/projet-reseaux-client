package event;

import event.interfaces.*;
import request.receive.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
	private static volatile EventBus instance;
	private final CopyOnWriteArrayList<AuthentificationEventInterface> authentificationListeners = new CopyOnWriteArrayList<>();
	private final CopyOnWriteArrayList<SearchEventInterface> searchListeners = new CopyOnWriteArrayList<>();
	private final CopyOnWriteArrayList<SuccessEventInterface> successListeners = new CopyOnWriteArrayList<>();
	private final CopyOnWriteArrayList<ErrorEventInterface> errorListeners = new CopyOnWriteArrayList<>();
	private final CopyOnWriteArrayList<FullImageEventInterface> fullImageListeners = new CopyOnWriteArrayList<>();
	private final CopyOnWriteArrayList<LikeEventInterface> likeListeners = new CopyOnWriteArrayList<>();
	private final CopyOnWriteArrayList<SearchPerDayEventInterface> searchPerDayListeners = new CopyOnWriteArrayList<>();

	private EventBus() {
	}

	public static EventBus getInstance() {
		EventBus client = instance;

		if (client != null)
			return client;

		synchronized (EventBus.class) {
			if (instance == null)
				instance = new EventBus();
			return instance;
		}

	}

	public void subscribeToAuthentificationEvent(AuthentificationEventInterface listener) {
		authentificationListeners.add(listener);
	}

	public void unSubscribeToAuthentificationEvent(AuthentificationEventInterface listener) {
		authentificationListeners.remove(listener);
	}

	public void notifyAuthentificationListeners(AuthentificationResponse authentificationResponse) {
		authentificationListeners.forEach(obj -> obj.onAuthentificationResponse(authentificationResponse));
	}

	public void subscribeToSearchEvent(SearchEventInterface listener) {
		searchListeners.add(listener);
	}

	public void unSubscribeToSearchEvent(SearchEventInterface listener) {
		searchListeners.remove(listener);
	}

	public void notifySearchListeners(SearchResponse searchResponse) {
		searchListeners.forEach(obj -> obj.onSearchResponse(searchResponse));
	}

	public void subscribeToSuccessEvent(SuccessEventInterface listener) {
		successListeners.add(listener);
	}

	public void unSubscribeToSuccessEvent(SuccessEventInterface listener) {
		successListeners.remove(listener);
	}

	public void notifySuccessListeners(SuccessResponse successResponse) {
		successListeners.forEach(obj -> obj.onSuccessResponse(successResponse));
	}

	public void subscribeToErrorEvent(ErrorEventInterface listener) {
		errorListeners.add(listener);
	}

	public void unSubscribeToErrorEvent(ErrorEventInterface listener) {
		errorListeners.remove(listener);
	}

	public void notifyErrorListeners(ErrorResponse errorResponse) {
		errorListeners.forEach(obj -> obj.onErrorResponse(errorResponse));
	}

	public void subscribeToFullImageEvent(FullImageEventInterface listener) {
		fullImageListeners.add(listener);
	}

	public void unSubscribeToFullImageEvent(FullImageEventInterface listener) {
		fullImageListeners.remove(listener);
	}

	public void notifyFullImageListeners(FullImageResponse fullImageResponse) {
		fullImageListeners.forEach(obj -> obj.onFullImageResponse(fullImageResponse));
	}
	
	public void subscribeToLikeEvent(LikeEventInterface listener) {
		likeListeners.add(listener);
	}

	public void unSubscribeToLikeEvent(LikeEventInterface listener) {
		likeListeners.remove(listener);
	}

	public void notifyLikeListeners(LikeResponse likeResponse) {
		likeListeners.forEach(obj -> obj.onLikeResponse(likeResponse));
	}
	public void subscribeToSearchPerDayEvent(SearchPerDayEventInterface listener) {
		searchPerDayListeners.add(listener);
	}

	public void unSubscribeToSearchPerDayEvent(SearchPerDayEventInterface listener) {
		searchPerDayListeners.remove(listener);
	}

	public void notifySearchPerDayListeners(SearchPerDayResponse searchPerDayResponse) {
		searchPerDayListeners.forEach(obj -> obj.onSearchPerDayResponse(searchPerDayResponse));
	}


}