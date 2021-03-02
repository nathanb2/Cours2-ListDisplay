package com.example.cours2_listdisplay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {//je Precise que mon adapter utilise un viewHolder custom
    private final ArrayList<User> mUsers;

    /**
     * @param users la liste d'objets que l'on souhaite afficher
     */
    public UserAdapter(ArrayList<User> users) {
        mUsers = users;
    }

    /**
     * @param parent c'est la recyclerview qui va contenir les items
     * @param viewType uniquement si l'on a different layout pour les items, pas montre dans ce code
     * @return une instance de UserViewHolder a laquelle on passe en paraemtre l'instance du xml du layout de l'item cree
     * Nous avons donc creer un item graphique
     * Cette fonction est appele par la classe mere autemps de fois qu'elle a d'instance de UserViewHolder a creer
     */
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //instanciation du layout de l'item
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(itemView);
    }

    /**
     * onBindViewHolder est appelee autemps le nombre de fois que getItemCount() retourne (taille de la liste)
     * elle recoit en parametre un item graphique et la position pour laquelle elle est appele et permet ainsi
     * de lier l'item graphique au membre de la liste se trouvant a l'index position
     * @param holder l'item graphique
     * @param position la position pour laquelle la fonction est appele (correspond a la position dans la liste d'objet que nous allons traiter)
     *                 (position va de 0 a la taille de la liste et plus precisement de 0 a ce que retourne getitemCount())
     *
     */
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //on recupere le user a l'index position
        User user = mUsers.get(position);
        //on set le nom et l'age du user a cette position dasn le textview du viewHolder qui represente l'item graphique dedie a cette position
        holder.mDetailsTv.setText(String.format(Locale.getDefault(), "%s age de %d", user.getName(), user.getAge()));
        if (user.getAge() > 25) {
            holder.mContactIc.setImageDrawable(holder.mContactIc.getContext().getDrawable(R.drawable.ic_contact_red));
        } else {//les viewHolder etant reutiliser pour differentes position, dasn onBindViewHolder
            // si on fait un if on fait forcement un else (pour remodifier une eventuel modification precedente sur le meme viewHolder)
            holder.mContactIc.setImageDrawable(holder.mContactIc.getContext().getDrawable(R.drawable.ic_contact_blue));
        }
    }

    /**
     * @return Indique a l'adapter combien d'item il doit gerer : donc la taille de la liste
     */
    @Override
    public int getItemCount() {
        if (mUsers != null) {
            return mUsers.size();
        }
        return 0;
    }

    /**
     * Objet qui permet de contenire une instance du layout de l'item (recu en parametre du constructor)
     * L'instance (les instances) sont crees dasn onCreateViewHolder
     * UserViewHolder represente un item graphique
     */
    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private final TextView mDetailsTv;
        private final ImageView mContactIc;

        /**
         * @param itemView itemView est la vue du layout de l'item R.layout.item_user, instancie dasn onCreateViewHolder
         */
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            //via itemView qui est l'instance de mon layout, je peux recuperer les differentes vues qui compose ce layout
            mDetailsTv = itemView.findViewById(R.id.IU_details_tv);
            mContactIc = itemView.findViewById(R.id.IU_contact_ic);
        }
    }
}
