package com.urise.webapp.exception;

public class NotExistException extends StorageException {
    public NotExistException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
