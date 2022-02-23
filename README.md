# autopieces-api
Une société de ventes de pièces détachées automobiles utilise un logiciel pour lister les coûts de production de chacun de ses 1300 articles (3-TIER interne exploité en client lourd, API avec données extractibles depuis le LAN). Elle a besoin d'afficher des prix différenciés pour chacun de ses clients en fonction des contrats cadres. Il y a 25 clients répartis en 5 contrats cadres pouvant évoluer, chacun margeant de 5% à 25%, de nouveaux clients sont potentiellement à venir. Votre groupe devra développer en langage Java le logiciel front/back/BDD (très simple et sans design) pour lister les produits et coûts de fabrication. Une API pour authentifier les clients et leur présenter les prix d'achat en fonction de leur contrat cadre. (pour les produits, vous pouvez créer une dizaine d'entrées en dur dans la BDD. Idem pour les 5 contrats cadre)

# Check if Maven is installed :

mvn -v

# To install on MAC : 
brew install maven

# To install on Windows :

# To run 
mvn clean install
mvn spring-boot:run OU mvn spring-boot:run -Dspring-boot.run.profiles=dev

