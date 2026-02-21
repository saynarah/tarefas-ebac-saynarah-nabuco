CREATE TABLE animal (
    id INT AUTO_INCREMENT NOT NULL,
    temporary_name VARCHAR(100) NOT NULL,
    estimated_age INT NOT NULL,
    breed VARCHAR(50) NOT NULL,
    date_entry DATE NOT NULL,
    adoption_date DATE,
    description_conditions VARCHAR(255) NOT NULL,
    name_worker VARCHAR(255) NOT NULL,
    death_date DATE,
    size VARCHAR(10) NOT NULL,
    animal_type VARCHAR(50) NOT NULL,
    CONSTRAINT pk_animal PRIMARY KEY (id)

);