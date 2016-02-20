Данный проект разрабатывался с использованием следующих технологий:

-Spring MVC

-Spring Security

-Hibernate

-HSQLDB, MySql

-Tomcat (с запуском Jetty возникли проблемы)
ва
в среде разработки NetBeans 8.1.


Чтобы запустить приложение необходимо:

1. В свойствах базы данных DiscService\WebContent\WEB-INF\jdbc.properties установить нужное имя пользователя и пароль к базе HSQLDB
2. Запустить проект.

Необходимые таблицы создаются автоматически и заполняются данными.

автоматически создается три пользователя:

1.Пользователь: логин: admin
   		пароль: admin


2.Пользователь: логин: feb
		пароль: feb


3.Пользователь: логин: user
   		пароль: user

Изначально все диски свободны, поэтому чтобы увидеть работу приложения нужно зайти под одним пользователем выполнить
какие-либо действия(взять диск, создать диск, удалить диск), а потом зайти под другим, чтобы увидеть результат изменения.

страницы:

1. login.jsp - страница авторизации
2. discs.jsp - заведение нового диска в базу данных
3. freediscs.jsp - список свободных дисков
4. discsfromme.jsp - взятые у меня диски
5. mytakendiscs.jsp - диски, которые я взял
6. mydiscs.jsp - список всех моих дисков

Внимание: 

1.в базе данных не отображаются русские символы
2.в формах нет валидации вводимых данных.
