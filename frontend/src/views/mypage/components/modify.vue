<template>
  <div class="modify-wrap">
    <span class="modify-title">프로필 수정하기</span>
    <div class="form-wrap">
      <div class="modify-image">
        <img class="modi-img" :src="state.imageurl" />
        <label for="chooseFile" class="upload-btn">사진변경</label>
        <input
          type="file"
          id="chooseFile"
          name="chooseFile"
          accept="image/*"
          style="display: none"
          @change="loadf"
        />
      </div>
    </div>
    <div class="submit-wrap">
      <q-btn class="subbtn" type="submit" @click="modify" label="수정하기" />
      <q-btn
        class="subbtn"
        type="submit"
        @click="basicimage"
        label="기본이미지로 변경하기"
      />
    </div>
  </div>
</template>
<script>
import { reactive } from "vue";
import { useStore } from "vuex";

export default {
  name: "modify",
  setup() {
    const store = useStore();
    const state = reactive({
      user: JSON.parse(localStorage.getItem("userInfo")),
      imageurl: require("../../../assets/malang.png"),
      file: null,
    });

    /*ㅡㅡㅡㅡㅡ 버튼 ㅡㅡㅡㅡㅡ*/
    const loadf = () => {
      var file = document.getElementById("chooseFile");
      state.imageurl = URL.createObjectURL(file.files[0]);
    };

    const modify = () => {
      const formData = new FormData();
      const img = document.getElementById("chooseFile").files[0];
      formData.append("email", state.user.email);
      if (img != null) {
        formData.append("image", img);
      }

      // console.log(state.user.email);
      // console.log(state.img);

      store
        .dispatch("root/requestUserModify", formData)
        .then((response) => {
          console.log(response.data.message);
          if (response.data.message === "Success") {
            alert("변경이 완료되었습니다.");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    };

    const basicimage = () => {
      const formData = new FormData();
      formData.append("email", state.user.email);
      formData.append("image", null);

      // console.log(state.user.email);
      // console.log(state.img);

      store
        .dispatch("root/requestUserModify", formData)
        .then((response) => {
          console.log(response.data.message);
          if (response.data.message === "Success") {
            alert("변경이 완료되었습니다.");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    };
    return {
      state,
      loadf,
      modify,
      basicimage,
    };
  },
};
</script>
