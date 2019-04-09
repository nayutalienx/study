package com.company;

public class Test {
    public static void putArrayOfString(String[] strings){
        if(strings==null)return;
        for(int i = 0; i<strings.length;i++){
            if(strings[i]==null) break;
            System.out.println(strings[i]);
        }
    }
    public static void main(String[] args){
        String mySentence = " А Алина спрятала  ключик под  коврик ";
        System.out.println("Исходная строка:");
        System.out.println(mySentence);
        Sentence sent = new Sentence(mySentence);


        System.out.println("Массив слов исходной строки:");
        putArrayOfString(sent.getWords());

        System.out.println("Массив слов, начинающихся на букву 'А'");
        putArrayOfString(sent.getWordsByFirstCharacter('А'));
        System.out.println("Слова, которые начинаются на 'с' и заканчиваются на 'а'");
        System.out.println(sent.getByFirstLastCharacter('с','а'));
        System.out.println("Дополнительные задания");
        System.out.println("1.Сколько раз подстрока 'ая' входит в строку 'ая красная, зеленая, фиолетовая'");
        int temp = StringProcessLib.compSubStr("ая красная, зеленая, фиолетовая","ая");
        System.out.printf("Ответ: %d\n", temp);
        System.out.println("2. Строка, склееная из двух сравненных лексикографически строк в порядке меньшая, большая");
        System.out.println("Исходные 2 строки: 'Море возможностей.' и 'СевГу лучший университет!'");
        System.out.println("Результат сравнения и склеивания:");
        System.out.println(StringProcessLib.compareAndCreateStr("Море возможностей.","СевГу лучший университет!"));
    }
}
