package org.mingle.banana.spring.jmx;

import javax.management.Notification;
import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
@ManagedResource("spitter:name=SpitterNotifier")
@ManagedNotification(notificationTypes = "SpittleNotifier.OneMillionSpittles", name = "TODO")
public class SpittleNotifierImpl implements NotificationPublisherAware,
		SpittleNotifier {

	private NotificationPublisher notificationPublisher;

	public void setNotificationPublisher(
			NotificationPublisher notificationPublisher) {
		this.notificationPublisher = notificationPublisher;
	}

	public void millionthSpittlePosted() {
		notificationPublisher.sendNotification(
				new Notification("SpittleNotifier.OneMillionSpittles", this, 0));
	}

	// @ManagedNotification
	Notification myNotification;

}
