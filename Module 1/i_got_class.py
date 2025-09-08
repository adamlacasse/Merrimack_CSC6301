class IGotClass:
    """
    A fun example class that demonstrates basic object-oriented programming concepts.
    
    This class stores a value and provides methods to display it, modify it,
    and perform various operations on it.
    
    Attributes:
        value (str): The main value stored in the instance
        creation_count (int): Class variable tracking how many instances have been created
    """
    
    # Class variable to track instance creation
    creation_count = 0
    
    def __init__(self, initial_value="I am a class instance"):
        """
        Initialize a new IGotClass instance.
        
        Args:
            initial_value (str, optional): The initial value to store. 
                                         Defaults to "I am a class instance".
        """
        self.value = initial_value
        IGotClass.creation_count += 1
        self.instance_id = IGotClass.creation_count
    
    def display(self):
        """
        Display the current value stored in the instance.
        
        Prints the value to the console with a formatted message.
        """
        print(f"Instance #{self.instance_id}: {self.value}")
    
    def update_value(self, new_value):
        """
        Update the stored value with a new value.
        
        Args:
            new_value (str): The new value to store in the instance
            
        Returns:
            str: The previous value that was replaced
        """
        old_value = self.value
        self.value = new_value
        return old_value
    
    def get_value_length(self):
        """
        Get the length of the current value.
        
        Returns:
            int: The number of characters in the current value
        """
        return len(self.value)
    
    def make_uppercase(self):
        """
        Convert the current value to uppercase.
        
        Modifies the value in place and returns the new uppercase value.
        
        Returns:
            str: The value converted to uppercase
        """
        self.value = self.value.upper()
        return self.value
    
    def add_suffix(self, suffix):
        """
        Add a suffix to the current value.
        
        Args:
            suffix (str): The text to append to the current value
            
        Returns:
            str: The new value with the suffix added
        """
        self.value += suffix
        return self.value
    
    @classmethod
    def get_creation_count(cls):
        """
        Get the total number of instances created.
        
        Returns:
            int: The number of IGotClass instances that have been created
        """
        return cls.creation_count
    
    def __str__(self):
        """
        Return a string representation of the instance.
        
        Returns:
            str: A formatted string showing the instance ID and value
        """
        return f"IGotClass(#{self.instance_id}: '{self.value}')"
    
    def __repr__(self):
        """
        Return a detailed string representation for debugging.
        
        Returns:
            str: A string that could be used to recreate the instance
        """
        return f"IGotClass(initial_value='{self.value}')"


# Demo usage of the class
if __name__ == "__main__":
    print("=== IGotClass Demo ===")
    
    # Create first instance with default value
    instance1 = IGotClass()
    instance1.display()
    
    # Create second instance with custom value
    instance2 = IGotClass("Hello, I'm instance #2!")
    instance2.display()
    
    # Demonstrate methods
    print(f"\nInstance 1 value length: {instance1.get_value_length()}")
    
    old_value = instance1.update_value("Updated value for instance 1")
    print(f"Updated instance 1. Old value was: '{old_value}'")
    instance1.display()
    
    # Make uppercase and add suffix
    instance2.make_uppercase()
    instance2.add_suffix(" - NOW IN CAPS!")
    instance2.display()
    
    # Show string representations
    print(f"\nString representation: {instance1}")
    print(f"Repr representation: {repr(instance2)}")
    
    # Show class method
    print(f"\nTotal instances created: {IGotClass.get_creation_count()}")
    
    # Create one more instance to show the counter
    instance3 = IGotClass("I'm the third one!")
    instance3.display()
    print(f"Total instances created: {IGotClass.get_creation_count()}")
