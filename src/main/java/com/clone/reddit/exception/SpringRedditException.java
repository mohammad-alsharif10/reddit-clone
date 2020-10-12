package com.clone.reddit.exception;

import org.springframework.mail.MailException;

public class SpringRedditException extends Throwable {
    public SpringRedditException(String s, MailException e) {
    }
}
