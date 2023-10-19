def print_info(name, age, *args, **kwargs):
    print(f"Name: {name}")
    print(f"Age: {age}")
    print("Additional Info (args):", args)
    print("Additional Info (kwargs):", kwargs)

print_info("Alice", 30, "Female", "New York", hobby="Reading", profession="Engineer")
