;;; Sierra Script 1.0 - (do not remove this comment)
(script# 740)
(include sci.sh)
(use Main)
(use LBRoom)
(use PFollow)
(use Osc)
(use RandCycle)
(use PolyPath)
(use CueObj)
(use n958)
(use Sound)
(use Jump)
(use Cycle)
(use View)
(use Obj)

(public
	rm740 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)
(instance rm740 of LBRoom
	(properties
		noun 9
		picture 740
		north 480
		west 730
	)
	
	(method (init)
		(global2 obstacles: (List new:))
		((ScriptID 2740 0) doit: (global2 obstacles?))
		(gEgo
			init:
			normalize: 732
			ignoreActors: 1
			actions: egoActions
		)
		(gGame handsOff:)
		(proc958_0 128 734 742 812 745)
		(proc958_0 132 736 52)
		(Palette palSET_INTENSITY 0 255 0)
		(super init:)
		(sFXRats play:)
		(gIconBar disable: 7)
		(= local0 1)
		(steve init:)
		(rat1 init: setCycle: RTRandCycle)
		(rat2 init: setCycle: RTRandCycle)
		(rat3 init: setCycle: RTRandCycle)
		(rat4 init: setCycle: RTRandCycle)
		(rat5 init: setCycle: RTRandCycle)
		(floor init: setOnMeCheck: 1 8)
		(wall init: setOnMeCheck: 1 16)
		(furnaceExit init:)
		(tRexExit init:)
		(gLb2DH add: self)
		(gLb2WH add: self)
		(self setScript: sEnterSouth)
	)
	
	(method (doit)
		(super doit:)
		(if local0
			(Palette palSET_INTENSITY 0 255 (= local1 (+ local1 2)))
			(if (>= local1 100)
				(= local0 0)
				(steve setScript: sGunShots)
			)
		)
		(cond 
			(script)
			((proc0_1 gEgo 2) (self setScript: sBurnEm))
			((proc0_1 gEgo 4) (self setScript: sGoTRex))
			(
			(and (> (gEgo x?) 211) (== (gEgo view?) 732)) (gEgo view: 745 cycleSpeed: 6 moveSpeed: 6 xStep: 3))
			(
			(and (< (gEgo x?) 212) (== (gEgo view?) 745)) (gEgo view: 732 cycleSpeed: 4 moveSpeed: 4 xStep: 2))
		)
	)
	
	(method (dispose)
		(proc958_0 0 930 991)
		(gLb2DH delete: self)
		(gLb2WH delete: self)
		(DisposeScript 2740)
		(gWrapSound fade:)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(return
			(cond 
				(
					(and
						(& (pEvent type?) evJOYSTICK)
						(== (gIconBar curIcon?) (gIconBar walkIconItem?))
						(or
							(== (pEvent message?) JOY_LEFT)
							(== (pEvent message?) JOY_UPLEFT)
							(== (pEvent message?) JOY_DOWNLEFT)
						)
					)
					(pEvent claimed: 1)
				)
				((& (pEvent type?) evMOVE)
					(if (< gX (gEgo x?))
						(pEvent claimed: 1)
					else
						(return 0)
					)
				)
				(else (return 0))
			)
		)
	)
	
	(method (cue)
		(gGameMusic2 number: 16 loop: -1 flags: 1 play:)
	)
)

(instance sGunShots of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 52 flags: 1 play: self)
			)
			(1 (= ticks 30))
			(2 (sFX play: self))
			(3
				(gLb2Messager say: 8 0 0 0 global2)
				(gGame handsOn:)
				(gIconBar disable: 7)
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(steve
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setMotion: PFollow gEgo 36
				)
				(gEgo
					setLoop: 0
					posn: 10 209
					edgeHit: 0
					setCycle: Walk
					cycleSpeed: 4
					moveSpeed: 4
					xStep: 2
					setMotion: MoveTo 89 163 self
				)
			)
			(1
				(rat3 setScript: sRat3Movement)
				(self dispose:)
			)
		)
	)
)

(instance sBurnEm of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 744
					setLoop: 2
					setCel: 0
					ignoreActors: 1
					cycleSpeed: 12
					setCycle: End self
				)
				(steve ignoreActors: 1)
			)
			(1
				(gGameMusic2 stop:)
				(sFXFall play:)
				(gEgo
					setPri: 5
					moveSpeed: 3
					yStep: 4
					setCycle: 0
					setMotion: MoveTo (gEgo x?) (+ (gEgo y?) 15) self
				)
			)
			(2
				(gEgo dispose:)
				(steve setMotion: PolyPath 239 106 self)
			)
			(3
				(sFXFall play:)
				(steve view: 744 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(steve
					setPri: 5
					moveSpeed: 3
					yStep: 4
					setMotion: MoveTo (steve x?) (+ (steve y?) 40) self
				)
			)
			(5 (= ticks 120))
			(6
				(gWrapSound number: 736 flags: 1 loop: 1 play:)
				(furnaceExit setCycle: Osc 1 self)
			)
			(7 (= ticks 120))
			(8
				(gWrapSound number: 736 flags: 1 loop: 1 play:)
				(furnaceExit setCycle: CT 4 1 self)
			)
			(9
				(furnaceExit setCycle: Beg self)
			)
			(10 (= seconds 3))
			(11
				(= global145 2)
				(global2 newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sGoTRex of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 745
					setLoop: 1
					ignoreActors: 1
					cycleSpeed: 10
					setCycle: End self
				)
				(steve ignoreActors: 1)
			)
			(1
				(steve setMotion: PolyPath 290 106 self)
			)
			(2
				(steve
					view: 745
					setLoop: 2
					cycleSpeed: 10
					setCycle: End self
					setMotion: MoveTo (gEgo x?) (- (gEgo y?) 2)
				)
			)
			(3
				(steve dispose:)
				(= cycles 2)
			)
			(4
				(global2 newRoom: (global2 north?))
				(self dispose:)
			)
		)
	)
)

(instance sRat3Movement of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(rat3
					loop: 1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo (- (rat3 x?) 30) (+ (rat3 y?) 16) self
				)
			)
			(2
				(rat3
					setMotion: MoveTo (+ (rat3 x?) 30) (- (rat3 y?) 16) self
				)
			)
			(3
				(rat3 setLoop: 3 cycleSpeed: 12 setCycle: RTRandCycle)
				(rat4 setScript: sRat4Movement)
				(self dispose:)
			)
		)
	)
)

(instance sRat4Movement of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat4
					loop: 1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo (- (rat4 x?) 36) (+ (rat4 y?) 21) self
				)
			)
			(1
				(rat4
					setMotion: MoveTo (+ (rat4 x?) 36) (- (rat4 y?) 21) self
				)
			)
			(2
				(rat4 setLoop: 3 cycleSpeed: 12 setCycle: RTRandCycle)
				(rat5 setScript: sRat5Movement)
				(self dispose:)
			)
		)
	)
)

(instance sRat5Movement of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat5
					loop: 1
					setCycle: Walk
					cycleSpeed: 6
					setMotion: MoveTo (- (rat5 x?) 40) (+ (rat5 y?) 22) self
				)
			)
			(1
				(rat5
					setMotion: MoveTo (+ (rat5 x?) 40) (- (rat5 y?) 22) self
				)
			)
			(2
				(rat5 setLoop: 3 cycleSpeed: 12 setCycle: RTRandCycle)
				(= seconds 4)
			)
			(3
				(rat1
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 51 182
				)
				(rat2
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 59 172
				)
				(rat3
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 66 175
				)
				(rat4
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 76 165
				)
				(rat5
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 84 165
				)
				(self dispose:)
			)
		)
	)
)

(instance sKillLaura of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameMusic2 number: 3 loop: 1 flags: 1 play:)
				(= local5 1)
				(rat1 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat2 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat3
					setLoop: 9
					setPri: 15
					setMotion: MoveTo (rat3 x?) (- (rat3 y?) 24) self
				)
				(rat4 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat5 setLoop: 3 setCycle: Fwd setMotion: 0)
			)
			(1
				(gEgo
					view: 734
					setLoop: 0
					setCel: 0
					cycleSpeed: 9
					setCycle: End
				)
				(rat3
					setLoop: 10
					setMotion: MoveTo (rat3 x?) (+ (rat3 y?) 24) self
				)
			)
			(2
				(rat1 setLoop: 1 setCycle: Walk setMotion: MoveTo 49 183)
				(rat2 setLoop: 1 setCycle: Walk setMotion: MoveTo 57 173)
				(rat3 setLoop: 1 setCycle: Walk setMotion: MoveTo 64 176)
				(rat4 setLoop: 1 setCycle: Walk setMotion: MoveTo 74 166)
				(rat5 setLoop: 1 setCycle: Walk setMotion: MoveTo 82 166)
				(self dispose:)
			)
		)
	)
)

(instance sKillSteve of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local6 1)
				(rat1 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat2 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat3
					setMotion: MoveTo (- (rat3 x?) 7) (+ (rat3 y?) 4) self
				)
				(rat4 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat5 setLoop: 3 setCycle: Fwd setMotion: 0)
			)
			(1
				(rat3
					setLoop: 9
					setPri: 15
					setMotion: MoveTo (rat3 x?) (- (rat3 y?) 18) self
				)
			)
			(2
				(steve
					view: 734
					setLoop: 1
					setCel: 0
					cycleSpeed: 9
					ignoreActors: 1
					setCycle: End
				)
				(rat3
					setLoop: 10
					setMotion: MoveTo (rat3 x?) (+ (rat3 y?) 18) self
				)
			)
			(3
				(rat3 setLoop: 3 setCycle: Fwd)
				(gGameMusic2 fade: self)
				(= seconds 20)
			)
			(4
				(if seconds (= seconds 0))
				(= global145 8)
				(global2 newRoom: 99)
				(self dispose:)
			)
		)
	)
)

(instance sRatsEatCheese of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rat1 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat2 setLoop: 3 setCycle: Fwd setMotion: 0)
				(if (rat3 script?)
					(rat3 setScript: sRat3Return)
				else
					(rat3 setLoop: 3 setCycle: Fwd setMotion: 0)
				)
				(if (rat4 script?)
					(rat4 setScript: sRat4Return)
				else
					(rat4 setLoop: 3 setCycle: Fwd setMotion: 0)
				)
				(if (rat5 script?)
					(rat5 setScript: sRat5Return)
				else
					(rat5 setLoop: 3 setCycle: Fwd setMotion: 0)
				)
				(gEgo
					view: 742
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg)
				(cheese
					init:
					posn: (+ (gEgo x?) 30) (- (gEgo y?) 31)
					setMotion: JumpTo (- (rat2 x?) 2) (+ (rat2 y?) 1) self
				)
			)
			(2
				(gEgo put: 16)
				((ScriptID 21 1) doit: 785)
				(= ticks 90)
			)
			(3
				(gLb2Messager say: 4 27)
				(cheese dispose:)
				(gEgo view: 732 setLoop: 0 setCel: 0)
				(rat1
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 51 182
				)
				(rat2
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 59 172
				)
				(rat3
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 66 175
				)
				(rat4
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 76 165
				)
				(rat5
					setLoop: 1
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 84 165
				)
				(self dispose:)
			)
		)
	)
)

(instance sRat3Return of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat3 setMotion: MoveTo 177 111 self)
			)
			(1
				(rat3 setLoop: 3 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance sRat4Return of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat4 setMotion: MoveTo 187 101 self)
			)
			(1
				(rat4 setLoop: 3 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance sRat5Return of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat5 setMotion: MoveTo 195 101 self)
			)
			(1
				(rat5 setLoop: 3 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance sRatsEnterFurnace of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rat1 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat2 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat3 setLoop: 3 setScript: 0 setCycle: Fwd setMotion: 0)
				(rat4 setLoop: 3 setScript: 0 setCycle: Fwd setMotion: 0)
				(rat5 setLoop: 3 setScript: 0 setCycle: Fwd setMotion: 0)
				(gEgo
					view: 742
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg)
				(cheese
					init:
					posn: (+ (gEgo x?) 30) (- (gEgo y?) 31)
					moveSpeed: 6
					setPri: 5
					setMotion: JumpTo 245 108 self
				)
			)
			(2
				(cheese dispose:)
				(gEgo view: 732 setLoop: 0 setCycle: Walk put: 16)
				((ScriptID 21 1) doit: 785)
				(rat1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 105 self
				)
			)
			(3
				(rat1 setLoop: 4 setMotion: MoveTo 211 104 self)
			)
			(4
				(rat1 setLoop: 6 cycleSpeed: 6 setCycle: Osc 1 self)
			)
			(5
				(rat1
					setCycle: 0
					setPri: 5
					setMotion: JumpTo 239 114 self
				)
			)
			(6
				(rat1 dispose:)
				(rat2
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 190 107 self
				)
			)
			(7
				(rat2
					setCycle: Fwd
					setPri: 5
					setMotion: JumpTo 238 117 self
				)
			)
			(8
				(rat2 dispose:)
				(rat3
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 105 self
				)
			)
			(9
				(rat3 setLoop: 4 setMotion: MoveTo 228 98 self)
			)
			(10
				(rat3 setLoop: 6 cycleSpeed: 6 setCycle: Osc 1 self)
			)
			(11
				(rat3
					setPri: 5
					moveSpeed: 0
					yStep: 4
					setMotion: MoveTo 228 110 self
				)
			)
			(12
				(rat3 dispose:)
				(rat4
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 105 self
				)
			)
			(13
				(rat4 setLoop: 4 setMotion: MoveTo 211 104 self)
			)
			(14
				(rat4
					setCycle: Fwd
					setPri: 5
					setMotion: JumpTo 246 94 self
				)
			)
			(15
				(rat4 setLoop: 2 setCel: 7 setCycle: 0 moveSpeed: 9)
				(= ticks 45)
			)
			(16
				(rat4 setMotion: MoveTo 246 110 self)
			)
			(17
				(rat4 dispose:)
				(rat5
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 190 107 self
				)
			)
			(18
				(rat5
					setLoop: 8
					cycleSpeed: 9
					setCycle: Fwd
					setPri: 5
					setMotion: JumpTo 238 117 self
				)
			)
			(19
				(rat5 dispose:)
				(sFXRats fade:)
				(gLb2Messager say: 7 0 8)
				(= local2 1)
				(gGame handsOn:)
				(gIconBar disable: 7)
				(self dispose:)
			)
		)
	)
)

(instance sRatsEnterRex of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rat1 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat2 setLoop: 3 setCycle: Fwd setMotion: 0)
				(rat3 setLoop: 3 setScript: 0 setCycle: Fwd setMotion: 0)
				(rat4 setLoop: 3 setScript: 0 setCycle: Fwd setMotion: 0)
				(rat5 setLoop: 3 setScript: 0 setCycle: Fwd setMotion: 0)
				(gEgo
					view: 742
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: Beg)
				(cheese
					init:
					posn: (+ (gEgo x?) 30) (- (gEgo y?) 31)
					moveSpeed: 6
					setPri: 5
					setMotion: JumpTo 295 105 self
				)
			)
			(2
				(cheese dispose:)
				(gEgo view: 732 setLoop: 0 setCycle: Walk put: 16)
				((ScriptID 21 1) doit: 785)
				(rat1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 105 self
				)
			)
			(3
				(rat1 setLoop: 4 setMotion: MoveTo 266 103 self)
			)
			(4
				(rat1 setLoop: 6 cycleSpeed: 6 setCycle: Osc 1 self)
			)
			(5
				(rat1
					setCycle: 0
					setPri: 5
					setMotion: JumpTo 291 112 self
				)
			)
			(6
				(rat1 dispose:)
				(rat2
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 190 107 self
				)
			)
			(7
				(rat2
					setCycle: Fwd
					setPri: 5
					setMotion: JumpTo 291 112 self
				)
			)
			(8
				(rat2 dispose:)
				(rat3
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 105 self
				)
			)
			(9
				(rat3 setLoop: 4 setMotion: MoveTo 266 103 self)
			)
			(10
				(rat3 setLoop: 4 setMotion: MoveTo 281 98 self)
			)
			(11
				(rat3 setLoop: 6 cycleSpeed: 6 setCycle: Osc 1 self)
			)
			(12
				(rat3
					setPri: 5
					moveSpeed: 0
					yStep: 4
					setMotion: MoveTo 281 111 self
				)
			)
			(13
				(rat3 dispose:)
				(rat4
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 194 105 self
				)
			)
			(14
				(rat4 setLoop: 4 setMotion: MoveTo 271 103 self)
			)
			(15
				(rat4
					setCycle: Fwd
					setPri: 5
					setMotion: JumpTo 299 94 self
				)
			)
			(16
				(rat4 setLoop: 2 setCel: 7 setCycle: 0 moveSpeed: 9)
				(= ticks 45)
			)
			(17
				(rat4 setMotion: MoveTo 299 119 self)
			)
			(18
				(rat4 dispose:)
				(rat5
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 190 107 self
				)
			)
			(19
				(rat5
					setLoop: 8
					cycleSpeed: 9
					setCycle: Fwd
					setPri: 5
					setMotion: JumpTo 283 112 self
				)
			)
			(20
				(rat5 dispose:)
				(sFXRats fade:)
				(gLb2Messager say: 7 0 9)
				(= local2 1)
				(proc0_3 46)
				(gGame handsOn:)
				(gIconBar disable: 7)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)
	
	(method (doVerb theVerb)
		(switch theVerb
			(27 (gLb2Messager say: 6 27) 1)
			(else  0)
		)
	)
)

(instance steve of Actor
	(properties
		x -10
		y 222
		noun 5
		view 733
		signal $4000
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			(
			(and (> (self x?) 211) (== (self view?) 733))
				(self
					view: 812
					cycleSpeed: 6
					moveSpeed: 6
					xStep: 3
					scaleSignal: 1
				)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gLb2Messager say: 1 1 27 0 0 1887)
			)
			(4
				(gLb2Messager say: 1 4 27 0 0 1887)
			)
			(8
				(gLb2Messager say: 1 8 27 0 0 1887)
			)
			(2
				(if local2
					(gLb2Messager say: 5 2 7)
				else
					(switch local4
						(0 (gLb2Messager say: 5 2))
						(else 
							(gLb2Messager say: 5 2 6)
						)
					)
					(++ local4)
				)
			)
			(27
				(gEgo put: 16)
				((ScriptID 21 1) doit: 785)
				(gLb2Messager say: 5 27)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance cheese of Actor
	(properties
		yStep 1
		view 742
		loop 2
		xStep 1
		moveSpeed 9
	)
)

(instance rat1 of Actor
	(properties
		x 162
		y 118
		noun 4
		view 741
		loop 3
		signal $4000
		cycleSpeed 18
		moveSpeed 4
	)
	
	(method (doVerb)
		(rat3 doVerb: &rest)
	)
)

(instance rat2 of Actor
	(properties
		x 170
		y 108
		noun 4
		view 741
		loop 3
		signal $4000
		cycleSpeed 18
		moveSpeed 4
	)
	
	(method (doVerb)
		(rat3 doVerb: &rest)
	)
)

(instance rat3 of Actor
	(properties
		x 177
		y 111
		noun 4
		view 741
		loop 3
		signal $4000
		cycleSpeed 18
		moveSpeed 4
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			(
				(and
					(< (self distanceTo: gEgo) 5)
					(== (gEgo view?) 732)
					(not local5)
				)
				(global2 setScript: sKillLaura)
			)
			(
				(and
					(< (self distanceTo: steve) 10)
					(== (steve view?) 733)
					(not local6)
				)
				(global2 setScript: sKillSteve)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(switch local3
					(0 (gLb2Messager say: 4 1 3))
					(1 (gLb2Messager say: 4 1 4))
					(else 
						(gLb2Messager say: 4 1 5)
					)
				)
				(++ local3)
			)
			(27
				(global2 setScript: sRatsEatCheese)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance rat4 of Actor
	(properties
		x 187
		y 101
		noun 4
		view 741
		loop 3
		signal $4000
		cycleSpeed 18
		moveSpeed 4
	)
	
	(method (doVerb)
		(rat3 doVerb: &rest)
	)
)

(instance rat5 of Actor
	(properties
		x 195
		y 101
		noun 4
		view 741
		loop 3
		signal $4000
		cycleSpeed 18
		moveSpeed 4
	)
	
	(method (doVerb)
		(rat3 doVerb: &rest)
	)
)

(instance furnaceExit of Prop
	(properties
		x 253
		y 33
		noun 3
		view 744
		signal $4001
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (< (gEgo x?) 202)
					(gLb2Messager say: 3 1 1)
				else
					(gLb2Messager say: 3 1 2)
				)
			)
			(27
				(if local2
					(super doVerb: theVerb)
				else
					(global2 setScript: sRatsEnterFurnace)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance tRexExit of Feature
	(properties
		x 287
		y 69
		noun 2
		nsTop 35
		nsLeft 271
		nsBottom 103
		nsRight 304
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (< (gEgo x?) 202)
					(gLb2Messager say: 2 1 1)
				else
					(gLb2Messager say: 2 1 2)
				)
			)
			(27
				(if local2
					(super doVerb: theVerb)
				else
					(global2 setScript: sRatsEnterRex)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance floor of Feature
	(properties
		y 1
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(27
				(if local2
					(super doVerb: theVerb)
				else
					(global2 setScript: sRatsEatCheese)
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance wall of Feature
	(properties
		y 1
		noun 1
	)
)

(instance sFXRats of Sound
	(properties
		flags $0001
		number 733
		loop -1
	)
)

(instance sFXFall of Sound
	(properties
		flags $0001
		number 542
	)
)

(instance sFX of Sound
	(properties
		flags $0001
	)
)
