"""
РЕФАКТОРИНГ: Лабораторная работа 1 - Улучшенное приложение сортировки слиянием
Добавлена валидация ввода, улучшена обработка ошибок и модульная структура
"""

class SortingApplication:
    """Главный класс приложения для операций сортировки"""
    
    def __init__(self):
        # РЕФАКТОРИНГ: Добавлена классовая структура для лучшей организации
        pass
    
    def get_user_input(self):
        """Получает и проверяет пользовательский ввод"""
        print("Введите числа для сортировки через пробел:")
        try:
            user_input = input().strip()
            if not user_input:
                raise ValueError("Пустой ввод")
                
            numbers = [float(x) for x in user_input.split()]
            # РЕФАКТОРИНГ: Добавлена валидация ввода
            if len(numbers) == 0:
                raise ValueError("Не введено ни одного числа")
                
            return numbers
        except ValueError as e:
            print(f"Ошибка: {e}")
            return None
    
    def merge_sort(self, arr):
        """Сортирует массив используя алгоритм сортировки слиянием"""
        # РЕФАКТОРИНГ: Добавлена валидация входных данных
        if arr is None:
            return []
            
        if len(arr) <= 1:
            return arr
            
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]
        
        left_sorted = self.merge_sort(left_half)
        right_sorted = self.merge_sort(right_half)
        
        return self.merge(left_sorted, right_sorted)
    
    def merge(self, left, right):
        """Объединяет два отсортированных массива"""
        result = []
        left_index = 0
        right_index = 0
        
        # РЕФАКТОРИНГ: Улучшена ясность алгоритма
        while left_index < len(left) and right_index < len(right):
            if left[left_index] <= right[right_index]:
                result.append(left[left_index])
                left_index += 1
            else:
                result.append(right[right_index])
                right_index += 1
        
        # Добавляем оставшиеся элементы
        result.extend(left[left_index:])
        result.extend(right[right_index:])
        
        return result
    
    def display_result(self, original, sorted_arr):
        """Отображает результаты сортировки"""
        print(f"\nИсходный массив: {original}")
        print(f"Отсортированный массив: {sorted_arr}")
        # РЕФАКТОРИНГ: Добавлена дополнительная информация
        print(f"Количество элементов: {len(sorted_arr)}")
    
    def run(self):
        """Главный цикл приложения"""
        # РЕФАКТОРИНГ: Добавлен цикл для множественных операций
        while True:
            data = self.get_user_input()
            if data is None:
                continue
                
            sorted_data = self.merge_sort(data.copy())
            self.display_result(data, sorted_data)
            
            print("\nХотите продолжить? (да/нет): ")
            choice = input().strip().lower()
            if choice != 'да':
                break

def main():
    """Точка входа в приложение"""
    # РЕФАКТОРИНГ: Использован классовый подход
    app = SortingApplication()
    app.run()

if __name__ == "__main__":
    main()