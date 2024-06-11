<template>
    <div id="administration">
        <NavigationBar />
        <div class="container">
            <div class="grid">
                <div class="row">
                    <div class="col">
                        <a class="btn btn-squared" href="#"
                            @click="showChangeRoleModal=true">
                            <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                            <span>Change Roles</span>
                        </a>
                    </div>
                    <!-- Example Column -->
                    <!-- <div class="col">
                        <a class="btn btn-squared">
                            <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                            <span>Button 2 ex</span>
                        </a>
                    </div> -->
                </div>
                <!-- Example Row -->
                <!-- <div class="row">
                    <div class="col">
                        <a class="btn btn-squared">
                            <font-awesome-icon :icon="['fas', 'user']" class="icon" />
                            <span>Button 3 ex</span>
                        </a>
                    </div>
                </div> -->
            </div>
        </div>
        <ChangeRole :isVisible="showChangeRoleModal" @close="showChangeRoleModal = false" />
    </div>
</template>

<script>

import NavigationBar from '@/components/NavigationBar.vue';
import ChangeRole from '@/views/ChangeRole.vue';

export default {
    name: 'administration',
    data() {
        return {
            showChangeRoleModal: false
        };
    },
    components: {
        NavigationBar,
        ChangeRole
    }
}

</script>

<style></style>
