# Static and Class Methods 
class person(object):
    population = 30
    def __init__(self, name,age): # constructor to initialise the variable
        self.name = name
        self.age

    @classmethod    
    def get_population(cls): # this is a class method 
        return cls.population
    
    # it is not necessary to create an object to call this method like the one called new person
    # instead this can be accessed by printing person.get_population() WHERE person is the class name

    @staticmethod
    def isAdult(age): # this is a static method
        return age >= 18 
    # it does not need a self as well as class parameter 
    def display(self):
        print(self.name,'is', self.age,'years old')

newperson = person('John', 25)

print(newperson.get_population())  # Accessing class method
print(person.get_population())  # Accessing class method directly from class
print(newperson.isAdult(25))  # Accessing static method