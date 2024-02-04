;;; Sierra Script 1.0 - (do not remove this comment)
(script# 335)
(include sci.sh)
(use Main)
(use LbDoor)
(use LBRoom)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use CueObj)
(use StopWalk)
(use Cycle)
(use Obj)

(public
	rm335 0
)

(instance rm335 of LBRoom
	(properties
		noun 5
		picture 335
		north 350
		south 330
	)
	
	(method (init)
		(gEgo
			init:
			normalize: (if (gEgo wearingGown?) 831 else 830)
			setScale: Scaler 100 75 190 160
		)
		(self setRegions: 90 93)
		(switch gGNumber
			(north
				(Palette palSET_INTENSITY 0 255 60)
				(if (and (proc0_10 8) (not (proc0_2 133)))
					(frontDoor
						cel: 255
						doorState: 2
						enterType: 2
						forceClose: 0
					)
					(self setScript: sOffToSmooch)
				else
					(frontDoor forceOpen: 1)
					(gEgo
						posn: (frontDoor moveToX?) (frontDoor moveToY?)
						edgeHit: 0
					)
				)
			)
			(south
				(self setScript: sEnterSouth)
				(cond 
					((!= global123 2))
					((proc0_2 25) (gWrapSound number: 335 flags: 1 setLoop: -1 play: 50))
					(else (gWrapSound number: 19 flags: 1 setLoop: -1 play:))
				)
			)
			(else 
				(gEgo posn: 150 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(southExitFeature init:)
		(frontDoor init: setPri: 12)
		(otherDoor init:)
		(banner init: approachVerbs: 4 8)
		(glass setOnMeCheck: 1 8192 init:)
		(column setOnMeCheck: 1 16384 init:)
		(if (and (== global123 2) (not (proc0_2 25)))
			((ScriptID 32 0)
				init:
				view: 341
				room: gNumber
				posn: 131 173 0
				setLoop: 0
				actions: doorActions
				approachX: 137
				approachY: 180
				approachVerbs: 4 11 2 6
			)
		else
			(frontDoor locked: (!= global123 2))
		)
	)
	
	(method (newRoom)
		(gWrapSound fade:)
		(super newRoom: &rest)
	)
)

(instance sEnterSouth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 165 240 setMotion: PolyPath 165 185 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitNorth of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(frontDoor caller: self open:)
			)
			(1
				(gEgo
					setMotion: PolyPath (frontDoor moveToX?) (frontDoor moveToY?) self
				)
			)
			(2
				(DrawPic 780 dpOPEN_FADEPALETTE)
				(gOldCast eachElementDo: #hide)
				(= cycles 2)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				((ScriptID 21 0) doit: 265)
				(global2 newRoom: (global2 north?))
			)
		)
	)
)

(instance sGiveInvite of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 32 0)
					setLoop: 0
					cycleSpeed: 6
					setCycle: CT 8 1 self
				)
			)
			(1 (= ticks 15))
			(2
				((ScriptID 32 0) setCycle: End self)
			)
			(3
				((ScriptID 32 0) setCel: 0)
				(= cycles 2)
			)
			(4
				(gLb2Messager say: 6 11 0 0 self)
			)
			(5
				(proc0_3 23)
				(gEgo put: 6)
				((ScriptID 21 1) doit: 775)
				((ScriptID 22 0) doit: 28673)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOffToSmooch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 153 160
					setScale: 0
					setStep: 3 2
					setMotion: MoveTo 160 250 self
				)
				(= cycles 1)
			)
			(1
				(DrawPic 335)
				(Palette palSET_INTENSITY 0 255 60)
				(= ticks 30)
			)
			(2
				((ScriptID 93 8)
					init:
					setCycle: StopWalk -1
					posn: 153 160
					setStep: 3 2
					setSpeed: 6
					setMotion: MoveTo 130 250
				)
			)
			(3 (global2 newRoom: 330))
		)
	)
)

(instance frontDoor of LbDoor
	(properties
		x 164
		y 162
		noun 3
		approachX 152
		approachY 173
		view 336
		moveToX 152
		moveToY 152
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond 
					((not (gEgo wearingGown?)) (gLb2Messager say: noun 4 6))
					((not (proc0_2 23)) (gLb2Messager say: noun 4 7))
					(else (global2 setScript: sExitNorth))
				)
			)
			(else  (super doVerb: theVerb))
		)
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsLeft 80
		nsBottom 189
		nsRight 290
		cursor 11
		exitDir 3
		noun 4
	)
)

(instance banner of Feature
	(properties
		x 215
		y 123
		noun 1
		nsTop 80
		nsLeft 203
		nsBottom 137
		nsRight 258
		sightAngle 40
	)
)

(instance glass of Feature
	(properties
		x 140
		y 70
		noun 2
		sightAngle 40
	)
)

(instance otherDoor of Feature
	(properties
		x 131
		y 141
		noun 954
		nsTop 115
		nsLeft 121
		nsBottom 167
		nsRight 142
		sightAngle 40
	)
	
	(method (doVerb theVerb)
		(if (== theVerb 4)
			(frontDoor doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance column of Feature
	(properties
		x 30
		y 170
		noun 8
		sightAngle 40
	)
)

(instance doorActions of Actions
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 (gLb2Messager say: 6 1) 1)
				(4 (gLb2Messager say: 6 4) 1)
				(11
					(global2 setScript: sGiveInvite)
				)
				(2
					(if (gEgo has: 6)
						(gLb2Messager say: 6 2 7)
					else
						(gLb2Messager say: 6 2)
					)
					1
				)
				(6 (gLb2Messager say: 6 2) 1)
				(else  (return 0))
			)
		)
	)
)
