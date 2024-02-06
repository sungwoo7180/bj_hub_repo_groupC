def find_min_bags(n):
    bags_5kg = n // 5
    while bags_5kg >= 0:
        remaining_sugar = n - (5 * bags_5kg)
        if remaining_sugar % 3 == 0:
            bags_3kg = remaining_sugar // 3
            return bags_3kg + bags_5kg
        bags_5kg -= 1
    return -1

user_input = int(input())

result = find_min_bags(user_input)

if result != -1:
    print(result)
else:
    print(-1)