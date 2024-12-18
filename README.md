# UCE Génie Logiciel Avancé : Techniques de tests

## Author
**Name:** Anthony Genti  
**Group:** CLA 1

## Build Status
[![CircleCI](https://circleci.com/gh/Anthony-genti/ceri-m1-techniques-de-test.svg?style=svg)](https://circleci.com/gh/Anthony-genti/ceri-m1-techniques-de-test)

## Test Coverage
[![codecov](https://codecov.io/gh/Anthony-genti/ceri-m1-techniques-de-test/branch/master/graph/badge.svg)](https://codecov.io/gh/Anthony-genti/ceri-m1-techniques-de-test)

## Badge javadoc

[![Javadoc](https://img.shields.io/badge/docs-javadoc-blue.svg)](https://<Anthony-genti>.github.io/ceri-m1-techniques-de-test/apidocs/)


## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante :
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

## Documentation
### Technical Choices
- **Language:** Java
- **Build Tool:** Maven
- **Testing Frameworks:** JUnit, Mockito
- **CI/CD:** CircleCI
- **Code Coverage:** JaCoCo, Codecov

### Project Description
Provide a brief description of your project here.

### How to Build and Test
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean package` to build the project.
4. Run `mvn test` to execute the tests.

### Additional Information
Add any additional information or documentation about your project here.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
