import { ApolloClient, createHttpLink, InMemoryCache } from '@apollo/client/core'
import { createApp, h, provide } from 'vue';
import App from './App.vue';


const httpLink = createHttpLink({
    uri: 'http://localhost:8080/graphql'
});

const cache = new InMemoryCache();

const apolloClient = new ApolloClient({
    link: httpLink,
    cache
});


const app = createApp({
    setup() {
        provide(ApolloClient, apolloClient)
    },
    render: () => h(App)
});

app.mount('#app');

export default apolloClient
