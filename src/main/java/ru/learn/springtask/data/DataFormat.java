package ru.learn.springtask.data;

import java.time.LocalDateTime;

/**
 * Общий интерфейс для потениально нескольких форматов
 */
public interface DataFormat {
    public String getUserName();
    public String getFio();
    public LocalDateTime getAccessDate();
    public String getApplication();
    public boolean isError();
    public void setUserName(String userName);
    public void setFio(String fio);
    public void setAccessDate(LocalDateTime accessDate);
    public void setApplication(String application);
    public void setError(boolean error);
    public String toString();
}
