<template>
    <div>
        <Number
            label="SubscriberId"
            v-model="value.subscriberId"
            :editMode="editMode"
        />
        <Number
            label="Point"
            v-model="value.point"
            :editMode="editMode"
        />
        <Boolean
            label="HasSubscriptionTicket"
            v-model="value.hasSubscriptionTicket"
            :editMode="editMode"
        />
        <Date
            label="SubscriptionTicketExpirationDate"
            v-model="value.subscriptionTicketExpirationDate"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Point',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "points",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
