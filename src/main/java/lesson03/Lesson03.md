Занятие 3. Классы и объекты.
================

Получение задач урока:
================
1. Открой терминал для выполнения команд git: **View -> Tool Windows -> Terminal** или `Alt + F12`<br>
2. Проверь, что git настроен на отслеживание изменений из upstream репозитория<br>
`git remote -v`<br>
Результат команды должен содержать строки:<br>
`upstream        https://github.com/MtuciLabs/java-practice-tasks.git (fetch)`<br>
`upstream        https://github.com/MtuciLabs/java-practice-tasks.git (push)`<br>
3. Если это не так, добавь ссылку на **upstream** репозиторий<br>
`git remote add upstream https://github.com/MtuciLabs/java-practice-tasks.git`<br>
4. Выполни _fetch_, чтобы увидеть изменения базового репозитория.<br>
`git fetch --all`<br>
5. Найди ветку `lesson03` и создай на ее основе локальную ветку по шаблону: **группа/фамилия-имя/lesson03** и переключись на нее.<br>
Пример: `but1801/ivanov-ivan/lesson03`

Также, эти шаги можно выполнить прямо через интерфейс Idea<br>
[Получение изменений из базового репозитория](https://github.com/MtuciLabs/java-lectures/blob/master/tutorials/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%B8%D0%B7%D0%BC%D0%B5%D0%BD%D0%B5%D0%BD%D0%B8%D0%B9%20%D0%B8%D0%B7%20%D0%B1%D0%B0%D0%B7%D0%BE%D0%B2%D0%BE%D0%B3%D0%BE%20%D1%80%D0%B5%D0%BF%D0%BE%D0%B7%D0%B8%D1%82%D0%BE%D1%80%D0%B8%D1%8F.md)<br>

Задание:
================
1. Напиши код к предложенным задачам, проверь программу на выполнение всех требований.<br>
2. Зафиксируй изменения в созданную ветку _(commit)_ и отправь их в GitHub _(push)_.<br>
3. Создай Pull Request в ветку lesson03 в репозитории [MtuciLabs/java-practice-tasks](https://github.com/MtuciLabs/java-practice-tasks).

Дополнительная информация:
================
[Зачем нужны конструкторы?](https://javarush.ru/groups/posts/konstruktory-v-java)<br>
[Конструкторы базовых классов](https://javarush.ru/groups/posts/1927-konstruktorih-bazovihkh-klassov--)<br>
[Геттеры и сеттеры](https://javarush.ru/groups/posts/1928-getterih-i-setterih)<br>
[Тернарный оператор (?:)](https://javarush.ru/groups/posts/ternarnyj-operator)<br>
[Жизненный цикл объекта](https://javarush.ru/groups/posts/1930-zhiznennihy-cikl-obhhekta--)<br>
[Ещё о сборщике мусора](https://javarush.ru/groups/posts/1931-ejshje-o-sborjshike-musora-)<br>
