**Второй участник проекта - мой старый аккаунт, сменил его уже после того, как написал основную часть проекта**

# a. Описание:
Простейший микросервис на базе **Spring boot** и **PostgreSQL**, позволяющий хранить текст в формате base64(text) вместе с атрибутами title, creation_date и description.\
Для упрощения кода использовалась библиотека **Lombok**. Так же в проекте есть несколько тестов на **JUnit** для тестирования всего функционала.\
**Тестировать только с включенным API**

Функционал:\
Обращаться к API(с текущими настройками) через localhost:8082/api/files
1. **GET запрос** - возвращает все записи из базы данных.
2. **POST запрос** - позволяет добавить запись в базу данных(в теле запроса должны быть поля text, title, creation_date, description). Возвращает ID записи из базы данных.
3. **GET запрос по адресу localhost:8082/api/files/{id}** возвращает запись из базы данных по указанному ID. В случае, когда запись не найдена, возвращает 404.
4. **DELETE запрос по адресу localhost:8082/api/files/{id}** удаляет запись из базы данных, всегда возвращает статус "OK".
# b. Инструкция по запуску
На данный момент - скачать проект, открыть в IDE(использовалась IntelijiIdea), запустить.\
На локальном компе должна быть развернута база postgreSQL по адресу localhost:8081/postgres. Логин и пароль от базы - postgres

# c. Примеры тестовых запросов
Тестировать можно через **Postman**.\
**Получение всех файлов из базы** - GET localhost:8082/api/files

**Получение конкретного файла по ID = 1** - GET localhost:8082/api/files/1

**Удаление конкретного файла по ID = 1** - DELETE localhost:8082/api/files/1

**Добавление нового файла в базу** -
POST localhost:8082/api/files\
body(JSON):\
{\
"text": "0J/RgNC40LLQtdGCINC80LjRgA==",\
"title": "Hello world text",\
"creation_date": "2024-23-07T13:24:00",\
"description": "Test file"\
}



