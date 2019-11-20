Занятие 4. Наследование, инкапсуляция, перегрузка, полиморфизм, абстракция, интерфейсы, instanceof.
================

Получение задач урока:
================
1. Убедись, что все твои изменения закомичены, иначе при манипуляциями с ветками они могут удалиться. 
Чтобы убедиться, открой **Version Control -> Local Changes**, там не должно быть никаких файлов.
2. Открой терминал для выполнения команд git: **View -> Tool Windows -> Terminal** или `Alt + F12`<br>
3. Проверь, что git настроен на отслеживание изменений из upstream репозитория<br>
`git remote -v`<br>
Результат команды должен содержать строки:<br>
`upstream        https://github.com/MtuciLabs/java-practice-tasks.git (fetch)`<br>
`upstream        https://github.com/MtuciLabs/java-practice-tasks.git (push)`<br>
4. Если это не так, добавь ссылку на **upstream** репозиторий<br>
`git remote add upstream https://github.com/MtuciLabs/java-practice-tasks.git`<br>
5. Выполни _fetch_, чтобы увидеть изменения базового репозитория.<br>
`git fetch --all`<br>
6. Переключись на ветку `lesson05`.<br>
`git checkout lesson05`
7. Создай новую ветку по шаблону: **группа_фамилия-имя/lesson05** (пример: `but1801/ivanov-ivan/lesson05`) и переключись на нее.<br>
`git checkout -b but1801_ivanov-ivan/lesson05`

Также, эти шаги можно выполнить прямо через интерфейс Idea<br>
[Получение изменений из базового репозитория](https://github.com/MtuciLabs/java-lectures/blob/master/tutorials/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%B8%D0%B7%D0%BC%D0%B5%D0%BD%D0%B5%D0%BD%D0%B8%D0%B9%20%D0%B8%D0%B7%20%D0%B1%D0%B0%D0%B7%D0%BE%D0%B2%D0%BE%D0%B3%D0%BE%20%D1%80%D0%B5%D0%BF%D0%BE%D0%B7%D0%B8%D1%82%D0%BE%D1%80%D0%B8%D1%8F.md)<br>


Задание:
================
1. Напиши код к предложенным задачам, проверь программу на выполнение всех требований.<br>
2. Зафиксируй изменения в созданную ветку _(commit)_ и отправь их в GitHub _(push)_.<br>
3. Создай Pull Request в ветку lesson05 в репозитории [MtuciLabs/java-practice-tasks](https://github.com/MtuciLabs/java-practice-tasks).

Дополнительная информация:
================
[Принципы ООП](https://javarush.ru/groups/posts/principy-oop)
[ООП — основные принципы](https://javarush.ru/quests/lectures/questcore.level01.lecture01)<br>
[Принципы объектно-ориентированного программирования](https://javarush.ru/groups/posts/1966-principih-obhhektno-orientirovannogo-programmirovanija)<br>
[Принципы инкапсуляции](https://javarush.ru/groups/posts/1969-principih-inkapsuljacii)<br>
[Перегрузка методов](https://javarush.ru/quests/lectures/questcore.level02.lecture03)<br>
[Методы, их параметры, взаимодействие и перегрузка](https://javarush.ru/groups/posts/1950-metodih-ikh-parametrih-vzaimodeystvie-i-peregruzka)<br>
[Как устроен механизм переопределения методов](https://javarush.ru/groups/posts/1975-kak-ustroen-mekhanizm-pereopredelenija-metodov-)<br>
[Для чего в Java нужны интерфейсы](https://javarush.ru/groups/posts/1981-dlja-chego-v-java-nuzhnih-interfeysih)<br>
[Интерфейсы — это больше чем интерфейсы — это поведение](https://javarush.ru/quests/lectures/questcore.level02.lecture08)<br>
[Разница между абстрактными классами и интерфейсами](https://javarush.ru/groups/posts/1985-raznica-mezhdu-abstraktnihmi-klassami-i-interfeysami)<br>
[Интерфейсы в ООП (Java), по-простому?](https://ru.stackoverflow.com/questions/136909/Интерфейсы-в-ООП-java-по-простому)<br>
[Преобразование типов](https://javarush.ru/quests/lectures/questsyntax.level10.lecture03)<br>
[Расширение и сужение примитивных типов](https://javarush.ru/groups/posts/1945-rasshirenie-i-suzhenie-primitivnihkh-tipov)<br>
[Оператор instanceof](https://javarush.ru/groups/posts/1402-operator-instanceof)<br>
[Instanceof и основы наследования](https://javarush.ru/groups/posts/1947-instanceof-i-osnovih-nasledovanija)<br>
[Как работает оператор Instanceof](https://javarush.ru/groups/posts/2018-kak-rabotaet-operator-instanceof)<br>
[Модификаторы доступа, переопределение методов, реализация абстрактных методов](https://javarush.ru/quests/lectures/questcore.level05.lecture01)<br>
[Перегрузка методов](https://javarush.ru/quests/lectures/questcore.level02.lecture03)<br>

[Презентация к уроку 4](https://github.com/MtuciLabs/java-lectures/blob/master/lectures/lecture04.pdf)<br>

