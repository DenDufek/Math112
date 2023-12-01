public class MathProcessor {

    @Math(num1 = 100, num2 = 200)
    public void mathSum(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("Sum: " + result);
    }

    public static void main(String[] args) {
        MathProcessor mathProcessor = new MathProcessor();
        mathProcessor.processMath();
    }

    public void processMath() {
        try {
            // Отримуємо екземпляр класу MathProcessor
            Class<?> mathProcessorClass = this.getClass();

            // Отримуємо всі методи класу
            java.lang.reflect.Method[] methods = mathProcessorClass.getMethods();

            // Проходимося по методах
            for (java.lang.reflect.Method method : methods) {
                // Перевіряємо, чи метод має анотацію Math
                if (method.isAnnotationPresent(Math.class)) {
                    // Отримуємо анотацію
                    Math mathAnnotation = method.getAnnotation(Math.class);

                    // Отримуємо значення параметрів анотації
                    int num1 = mathAnnotation.num1();
                    int num2 = mathAnnotation.num2();

                    // Викликаємо метод з вказаними параметрами
                    method.invoke(this, num1, num2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
