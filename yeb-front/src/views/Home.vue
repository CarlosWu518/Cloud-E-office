<template>
  <div>
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu router>
            <el-submenu
              index="1"
              v-for="(item, index) in this.$router.options.routes"
              v-if="!item.hidden"
              :key="index"
            >
              <template slot="title"
                ><i class="el-icon-location"></i>
                <span>{{ item.name }}</span>
              </template>
              <el-menu-item-group>
                <el-menu-item
                  :index="children.path"
                  v-for="(children, indexj) in item.children"
                  :key="indexj"
                  >{{ children.name }}</el-menu-item
                >
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {};
  },

  components: {},

  methods: {},
};
</script>

<style scoped>
</style>