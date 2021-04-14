
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class test {










    public static void main(String[] args) throws Exception {

        String str = "srm.settle-account.cost-sheet.cost-sheet.ps.radio.button.update,srm.settle-account.cost-sheet.cost-sheet.ps.radio.button.audit,srm.settle-account.cost-sheet.cost-sheet.ps.radio.button.completed," +
                "srm.settle-account.cost-sheet-sup-cost-sheet.ps.radio.button.audit," +
                "srm.settle-account.settle-pool.purchase.ps.radio.button.bill,srm.settle-account.settle-pool.purchase.ps.radio.button.invoice,srm.settle-account.settle-pool.purchase.ps.radio.button.payment," +
                "srm.settle-account.settle-pool.supply.ps.radio.button.bill,srm.settle-account.settle-pool.supply.ps.radio.button.invoice,srm.settle-account.settle-pool.supply.ps.radio.button.payment," +
                "srm.settle-account.reconciliation-workbench.purchaser.ps.radio.button.update,srm.settle-account.reconciliation-workbench.purchaser.ps.radio.button.audit,srm.settle-account.reconciliation-workbench.purchaser.ps.radio.button.cancel," +
                "srm.settle-account.reconciliation-workbench.supplier.ps.radio.button.update,srm.settle-account.reconciliation-workbench.supplier.ps.radio.button.audit,srm.settle-account.reconciliation-workbench.supplier.ps.radio.button.cancel," +
                "srm.settle-account.jsd.purchase.ps.radio.button.update,srm.settle-account.jsd.purchase.ps.radio.button.audit,srm.settle-account.jsd.purchase.ps.radio.button.cancel,srm.settle-account.jsd.purchase.ps.radio.button.sync,srm.settle-account.jsd.purchase.ps.button.create.invoice,srm.settle-account.jsd.purchase.ps.button.create.payment,srm.settle-account.jsd.purchase.ps.button.create.paymentinvoice,srm.settle-account.jsd.purchase.ps.button.create.prepayment," +
                "srm.settle-account.jsd.supply.ps.radio.button.update,srm.settle-account.jsd.supply.ps.radio.button.audit,srm.settle-account.jsd.supply.ps.radio.button.cancel,srm.settle-account.jsd.supply.ps.button.create.invoice,srm.settle-account.jsd.supply.ps.button.create.payment,srm.settle-account.jsd.supply.ps.button.create.paymentinvoice,srm.settle-account.jsd.supply.ps.button.create.prepayment," +
                "hzero.srm.requirement.prm.pr-creation.ps.submit,hzero.srm.requirement.prm.pr-creation.ps.save,hzero.srm.requirement.prm.pr-creation.ps.cancel,hzero.srm.requirement.prm.pr-creation.ps.delete," +
                "hzero.srm.requirement.prm.pr-cancel.ps.submit,hzero.srm.requirement.prm.pr-cancel.ps.close,hzero.srm.requirement.prm.pr-cancel.ps.cancel,hzero.srm.requirement.prm.pr-cancel.ps.line-close,hzero.srm.requirement.prm.pr-cancel.ps.line-cancel," +
                "srm.partner.my-partner.search-supplier.ps.sup-import,srm.partner.my-partner.search-supplier.ps.invite-register,";

        String[] arr = str.split(",");

        for (String s : arr) {
            System.out.println("delete from iam_role_permission WHERE permission_id = (SELECT id from iam_menu WHERE `code` =  '"+s+"') and h_create_flag = 'Y' and h_inherit_flag = 'N';" );
        }
//        int[] jobDifficulty = new int[]{2, 3, 1, 0, 2, 5, 3};
//        findRepeatNumber(jobDifficulty);

    }


    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     * @param nums
     * @return
     */
    private static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i:nums) {
//            Integer count = map.get(i);
//            if(null == count){
//                map.put(i,1);
//            }else {
//                map.put(i,count+1);
//            }
            map.merge(i, 1, Integer::sum);
        }
//        List<Integer> newList =
//        map.entrySet().forEach(mp -> {
//            if(mp.getValue()>1){
//            }
//        });


        return 2;
    }
}
