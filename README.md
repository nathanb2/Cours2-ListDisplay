# Cours2-ListDisplay
Display List with recyclerView and Adapter

- Methodologie decoupage de code

- Methodologie declaration de fonction : 3 questions a se poser:

 - 1 quel est l'objectif de la fonction
 - 2 de quels elements je dispose
 - 3 avec ce dont je dispose comment je realise l'objectif de ma fonction


Pour afficher une liste d'objets j'ai besoin de:

 - 1 Une recylerView dans le xml de mon activity, c'est la vue contener qui sait aceuillire une liste d'item
 - 2 Une list d'objets 
 - 3 Un Layout qui represente un item de la liste
 - 4 Un Adapter (class qui herite de la class Adapter) pour creer et associer un item graphique a chaque membre de ma liste (on passe la liste d'objets a l'adapter en parametre du constructor)
 
 L'Adapter se compose de:
 
  - Une sous class ViewHolder (qui herite de la class ViewHolder) qui va contenire l'instance d'un item graphique 
  - La fonction onCreateViewHolder qui permet de creer une instance du xml de l'item et de creer une instance du ViewHolder (que la fonction va retourner), l'instance de ViewHolder recoit en parametre l'instance du xml de l'item que nous avons creer
  - On peut alors dasn la class ViewHolder recuperer les differentes vues qui se trouve dans le Lyout de l'item avec findViewById (en passant pas la vue recu en parametre du constructeur qui n'est autre que l'instance du xml de l'item creer dans la fonction onCreateViewHolder)
  - La fonction onBindViewHolder qui recoit en parametre l'instance de ViehHolder creer dans onCreateViewHolder et la position pour laquelle nous voulons creer/actualiser la vue en fonction du membre correspondant de la liste d'objets
  - Ainsi on peut avec la position recuperer le membre voulu dasn la liste et via le viewholder acceder au differentes vues declarer dasn ViewHolder et leur seter les information correspondante au membre de la liste voulu 



- slide 04.5 https://drive.google.com/drive/folders/1eu-LXxiHocSktGYpG04PfE9Xmr_pBY5P?usp=sharing
