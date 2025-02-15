public class Message {
    public static String mainMenu = // ГЛАВНОЕ МЕНЮ.
            """ 
            Добро пожаловать в главное меню!
            Выбери с кем ты хочешь сыграть в "крестики и нолики":
            
            1. Играть с компьютером.
            2. Играть с другом.
            3. Правила игры.
            4. Выход.
            """;
    public static String mainMenuError = // НЕВЕРНЫЙ ВВОД В ГЛАВНОМ МЕНЮ.
            """            
            Неизвестная команда! Выбери пункт "1","2","3", или "4":
            """;
    public static String rules = // ПРАВИЛА.
            """
            Один из игроков играет «крестиками», второй — «ноликами».
            Игроки по очереди ставят на свободные клетки поля выбранные ими знаки (один всегда «крестики», другой всегда «нолики»).
            Выигрывает тот, кто первым выстроит из своих фигур ряд по вертикали, горизонтали или диагонали.
            """;
    public static String playerOneName = // ВВЕСТИ ИМЯ ИГРОКА 1
            """
            
            Окей. Введи имя игрока, который сыграет «крестиками»:
            """;
    public static String playerTwoName = // ВВЕСТИ ИМЯ ИГРОКА 2
            """
            
            А теперь введи имя игрока, который сыграет «ноликами»:
            """;
    public static String crossesOrNulls = // ВЫБОР КРЕСТИКОВ ИЛИ НОЛИКОВ
            """
            
            Окей!
            Введи в консоль команду "крестики" или "нолики", чтобы выбрать за кого будешь играть.
            Крестики ходят первыми. Удачи!
            """;
    public static String crossesOrNullsError = // НЕВЕРНЫЙ ВВОД ПРИ ВЫБОРЕ КРЕСТИКОВ ИЛИ НОЛИКОВ
            """
            
            Введена неизвестная команда.
            Введи в консоль слово "крестики" или слово "нолики".
            """;
    public static String playAgain = // ХОТИТЕ СЫГРАТЬ ЕЩЁ?
            """
            Хотите сыграть ещё?
                
            1. Да, давай!
            2. Не.
            """;
    public static String playAgainError = // НЕВЕРНЫЙ ВВОД СЫГРАТЬ ЕЩЁ
            """
            
            Неизвестная команда! Выбери пункт "1", или "2".
            Хотите сыграть ещё?
                
            1. Да, давай!
            2. Не.
            """;
    public static String byeBye = // ВЫХОД ИЗ ИГРЫ
            """         
            
            Спасибо за игру и хорошего дня!
            """;
}
