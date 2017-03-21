//
//        *     **                          **               *       **
//        **    **   *    **                *                 **     **
//         **  **    ********   ******      *    *            **    **
//         **  *     *    **        **  **********             *    *    *
//             * **  *   **         *       *   **        ****************
//      ************ *   *         **    ***********             **     **
//           **      *   *        **       **   **               **     **
//           **      *  *         *         *   **               **     **
//           **      *  *        **     **********         ***************
//           **   *  *  **      *******     *   *          *     **     **
//      ************ *   *           *      *             **     **
//           *       *    *          *  **********        **     **       *
//           *       *    **     *  **     **            *******************
//          ***      *    **     *  **      *                  ****       *
//          ** **    *    **      * *   ************           ****       *
//          *   **   *    **      ***      **                 ** **      **
//         **    **  * *****       **       *                **  **      **
//        **     **  *   **        **       *               **   **  *   **
//       **       *  *            *  ***    *             **     **   ****
//      **           *           *    ***************    **      **    **
//                   *          *        ***********             **




package com.zheng.poker.texas.client;

import com.zheng.poker.texas.client.model.Game;
import com.zheng.poker.texas.client.model.Holder;
import com.zheng.poker.texas.client.thread.*;
import com.zheng.poker.texas.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zheng on 2016/12/8.
 */
public class PlayTest {
    public static void main(String[] args){
        List<Thread> threads=new ArrayList<Thread>();
        threads.add(new ServerThread());
        threads.add(new AllInThread());
        threads.add(new CallThread());
        threads.add(new FoldThread());
        threads.add(new NormalThread());
       threads.add(new RaiseThread());
        threads.add(new TestThread());
        threads.add(new TestThread());
        threads.add(new TestThread());
        for(Thread thread:threads){
            thread.start();
        }
    }
}
