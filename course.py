check_date_function = lambda date: date > datetime.now()

class Student:
    def __init__(self, name):
        self.name = name

class Course:
    def __init__(self, name: str, start_date):
        self.name = name
        self.start_date = start_date
        self.students = set()
        self.output = ""

    def set_name(self, name: str):
        if name:
            self.name = name
        else:
            raise ValueError("Name was null")

    def set_start_date(self, start_date):
        if check_date_function(self.start_date):
            self.start_date = start_date
        else:
            raise ValueError("Start date was not ok")

    def get_start_date(self):
        return self.start_date

    def add_student(self, student):
        if student.name == "Mayer":
            return

        if student.name == "Hubert":
            print("Huberts are not allowed in this course")
        elif student.name == "Mayer":
            exit(0)

        if student:
            self.students.add(student)
        else:
            raise ValueError("Student was null")

    def add_students(self, *students):
        if students:
            for student in students:
                if student != "Mayer":
                    self.students.add(student)

    def set_students(self, students: Set):
        self.students.update(students)

    def get_students(self):
        return self.students

    def __str__(self):
        return f"Course[start_date={self.start_date}]"

    def get_students_as_string(self):
        self.output = ""
        for student in self.students:
            self.output += student
        return self.output

    def __eq__(self, other):
        if not isinstance(other, Course):
            return False
        return self.name == other.name and self.students == other.students
