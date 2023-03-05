<template>
    <div>
        {{ message }}
    </div>
</template>

<script>
/**
 * Axios vs Fetch
 * - https://blog.logrocket.com/axios-vs-fetch-best-http-requests/
 */

// TODO: Axois as Global Object in Vue
export default {
    data() {
        return {
            message: '(Message from API)'
        }
    },
    created() {
        axios.get('/api/hello')
            .then(res => this.message = res.data)
    }
}
</script>
