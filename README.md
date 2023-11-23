# Maze_Runner
Описание проекта:  
Научитесь использовать случайный класс со списками и многомерными массивами и сохранять результаты в файле.
Лабиринты удивительны: продолжай бежать, найди выход, если сможешь! Если тебе не очень нравится застревать в реальном лабиринте,
ты можешь развлечь себя виртуальным. В этом проекте вы напишете программу, которая генерирует лабиринты и ищет выход.

Используемые технологии:    
Работа с разными структурами данных, сохранение и загрузка файлов, создание графовой системы из массивов и проход по ним.

1 этап.   
Реализуйте лабиринт как двумерный массив целых чисел. Если значение элемента равно 1, это стена. Если значение равно 0, это проход.
Ваш лабиринт должен быть размером 10х10. Другие правила следующие:
Вокруг лабиринта должны быть стены, за исключением двух ячеек: входа и выхода.
Любая пустая ячейка должна быть доступна со стороны входа или выхода из лабиринта. Перемещаться по диагонали невозможно,
только по вертикали или горизонтали.
Должен быть путь от входа к выходу. Не имеет значения, что считать входом, а что выходом, поскольку они взаимозаменяемы.
В лабиринте, состоящем только из стен, запрещено создавать блоки, например 3х3.
Чтобы распечатать массив, следуйте этим двум правилам:
для отображения прохода используйте два пробела;
для отображения стены используйте два символа блока подряд (одинаковые): █ (U+2588).
Вы можете распечатать стену следующим образом: System.out.print("\u2588\u2588").
Помните, что лабиринт виден только в том случае, если у вас моноширинный шрифт!
В противном случае символ пробела будет довольно маленьким по ширине.
На этом этапе не имеет значения, какой лабиринт вы отображаете.
Программа всегда может выводить один и тот же подготовленный лабиринт или один из набора подготовленных лабиринтов.   

2 этап.   
На этом этапе вы разработаете алгоритм создания лабиринта.
Не забывайте о правилах правильного лабиринта:
Вокруг лабиринта должны быть стены, за исключением двух ячеек: входа и выхода.
Любая пустая ячейка должна быть доступна со стороны входа или выхода из лабиринта.
Ходить по лабиринту по диагонали невозможно, только по вертикали и горизонтали.
Должен быть путь от входа к выходу. Не имеет значения, что считать входом, а что выходом, поскольку они взаимозаменяемы.
Лабиринт не должен содержать блоков размером 3х3, состоящих только из стен.
Постарайтесь заполнить все пространство лабиринта проходами.
Существует очень хороший алгоритм построения лабиринта, основанный на построении минимального связующего дерева.
Вы можете посмотреть видео о том, как работает этот алгоритм.
Должна быть возможность указать размер лабиринта.
После ввода пользователем размера программа должна напечатать лабиринт и затем остановиться.
Разбейте вашу программу на набор методов, чтобы ее было легко понять и добавить к ней или отредактировать позже.
Начиная с этого этапа, ваша программа должна каждый раз генерировать случайный лабиринт.  

3 этап.    
Программа должна предоставлять меню с пятью опциями:
Создайте новый лабиринт.
Загрузите лабиринт.
Сохраните лабиринт.
Отображение лабиринта.
Выход.
После создания или загрузки лабиринта из файла он становится текущим лабиринтом, который можно сохранить или отобразить.
Если текущий лабиринт (сгенерированный или загруженный) отсутствует,
пользователь не должен видеть опции сохранить и отобразить лабиринт.
Если пользователь выбирает опцию, для которой требуется файл, он должен ввести путь к файлу.
Вы всегда должны проверять результат обработки файлов и отображать удобные для пользователя сообщения.
Программа должна выводить лабиринт пользователю только в двух сценариях:
После создания лабиринта;
После выбора опции отобразите лабиринт.
Ваша программа должна успешно обрабатывать следующие случаи:
если была выбрана неправильная опция, программа должна напечатать сообщение типаIncorrect option. Please try again;

если файл для загрузки лабиринта не существует, программа не должна останавливаться,
она должна напечатать сообщение типа The file ... does not exist;

если файл имеет недопустимый формат для лабиринта, программа не должна останавливаться,
но она должна напечатать сообщение типа Cannot load the maze. It has an invalid format.

Кстати, вы можете сохранить лабиринт в любом формате, тесты не проверяют содержимое файла.
Самое главное, что сохраненный лабиринт должен быть корректно загружен в программу.   

4 этап.    
Измените меню, добавив новую опцию:

1. Generate a new maze.
2. Load a maze.
3. Save the maze.
4. Display the maze.
5. Find the escape.
0. Exit.

Эта опция должна быть доступна только в том случае, если текущий лабиринт существует.

Не сохраняйте данные о пути выхода в файлы и не отображайте путь выхода,
когда пользователь выбирает четвертый вариант. Отметьте путь выхода / символом.
